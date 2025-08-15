import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { StudentInterface } from '../../../../features/students/interfaces/student.interface';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { StudentService } from '../../services/student.service';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-student.update.component',
  imports: [ReactiveFormsModule],
  templateUrl: './student.update.component.html',
  styleUrl: './student.update.component.scss'
})
export class StudentUpdateComponent implements OnInit {
  form!: FormGroup;
  loading = false;
  studentId: string;
  studentData: StudentInterface | null = null;

  constructor(
    private fb: FormBuilder,
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService
  ) {
    this.form = this.fb.group({
      documentNumber: ['', Validators.required],
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      photo: [''],
      active: [false]
    });

    this.studentId = this.route.snapshot.paramMap.get('uid')!;
  }

  async ngOnInit() {
    await this.loadStudentData();
  }

  async loadStudentData() {
    this.loading = true;
    try {
      const data = await firstValueFrom(
        this.studentService.getStudentById(this.studentId) // Observable<StudentInterface>
      );

      this.studentData = data;

      this.form.patchValue({
        documentNumber: data.documentNumber,
        name: data.name,
        lastName: data.lastName,
        phone: data.phone,
        email: data.email,
        photo: data.photo ?? '',
        active: data.active === 1 
      });
    } catch (err) {
      console.error(err);
      this.toastr.error('No se pudo cargar el alumno');
    } finally {
      this.loading = false;
    }
  }

  async save() {
    if (this.form.invalid) {
      this.toastr.error('El formulario contiene errores');
      this.form.markAllAsTouched();
      return;
    }

    this.loading = true;
    this.form.disable();

    try {
      const v = this.form.value;

      const payload: StudentInterface = {
        uid: this.studentId,
        documentNumber: v.documentNumber,
        name: v.name,
        lastName: v.lastName,
        phone: v.phone,
        email: v.email,
        photo: v.photo ?? null,
        active: v.active ? 1 : 0 // <-- mapeo a entero
      };

      await firstValueFrom(
        this.studentService.updateStudent(this.studentId, payload)
      );

      this.toastr.success('Alumno actualizado correctamente');
      this.router.navigate(['student']);
    } catch (e) {
      console.error(e);
      this.toastr.error('No se pudo actualizar el alumno');
      this.form.enable();
    } finally {
      this.loading = false;
    }
  }

  cancel() {
    this.router.navigate(['student']);
  }
}
