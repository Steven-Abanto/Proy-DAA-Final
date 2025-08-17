export interface Prestamo {
  tipoPrestamo: string;
  monto: number;
  fecha: Date;
}

export interface PrestamoDetalle {
  uidCuenta: number;
  montoPrestamo: number;
  tasaInt: number;
  cuotas: number;
  deuda_cuota: number;
  deuda_total: number;
  fecha: Date;
}

export interface PrestamoConDetalles {
  prestamo: Prestamo;
  detalles: PrestamoDetalle[];
}
