export interface LoanDetailsInterface {
    uidPrestamo: string;
    uidCuenta: string;
    montoPrestamo: number;
    tasaInt: number;
    cuotas: number;
    deudaCuota: number;
    deudaTotal: number;
    fecha: Date;
}
