export interface LoanDetailsInterface {
    uid_prestamo: string;
    uidCuenta: string;
    montoPrestamo: number;
    tasaInt: number;
    cuotas: number;
    deuda_cuota: number;
    deuda_total: number;
    fecha: Date;
}
