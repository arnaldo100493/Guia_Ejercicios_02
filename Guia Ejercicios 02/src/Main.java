/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FABAME
 */
public class Main {

    public static Console c = new Console("GUIA EJERCICIOS 02");

    public Main() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ejercicio01();
        //ejercicio02();
        ejercicio3();
    }

    /* 
    * Se tiene una fábrica de mermelada las que son 
    * entregadas al mercado en bolas y frascos.
    * Las bolsas son de 1/4 y 1/2 kilo y sus precios son de $300 y $500 respectivamente. 
    * Los frascos son 1 y 2 kilos y sus precios son de $1.200 y $2.400 respectivamente. 
    * Además por cada 10 frascos que compre, uno de ellos es gratis.
    * Se pide realizar el programa para 500 ventas:
    *
    * Imprimir cuántos frascos de mermelada se vendieron.
    * Cuántos kilos se vendieron en total.
    * Entregue el monto de venta de mermelada en bolsa.
    * Imprimir se se vendieron más frascos o bolsas.
    *
     */
    public static void ejercicio01() {
        int cantidadVentas = 1;

        int bolsasVendidas = 0;
        int frascosVendidos = 0;
        int totalKgVendidos = 0;

        int totalVentasBolsa = 0;
        int totalVentasFrasco = 0;

        int precioBolsa1 = 300;
        int precioBolsa2 = 500;
        int precioFrasco1 = 1200;
        int precioFrasco2 = 2400;
        int totalFrascosGratis = 0;

        for (int i = 1; i <= cantidadVentas; i++) {

            int precio = 0;
            int cantidadKg = 0;
            int cantidad = 0;
            int totalVenta = 0;
            int descuento = 0;
            c.println("Ingrese tipo: [1] Bolsa [2] Frasco");
            int tipoEnvase = c.readInt();

            // Compra en Bolsa
            if (tipoEnvase == 1) {

                c.println("Ingrese el tamaño: [1] 1/4Kg [2] 1/2Kg");
                int tamanioEnvase = c.readInt();

                c.println("Ingrese la cantidad:");
                cantidad = c.readInt();

                bolsasVendidas += cantidad;

                if (tamanioEnvase == 1) {
                    precio = precioBolsa1;
                    cantidadKg = 250;

                }

                if (tamanioEnvase == 2) {
                    precio = precioBolsa2;
                    cantidadKg = 500;
                }

                totalVenta = cantidad * precio;
                totalVentasBolsa += totalVenta;

            }

            // Compra en Frasco
            if (tipoEnvase == 2) {

                c.println("Ingrese el tamaño: [1] 1Kg [2] 2Kg");
                int tamanioEnvase = c.readInt();

                c.println("Ingrese la cantidad:");
                cantidad = c.readInt();

                frascosVendidos += cantidad;

                if (tamanioEnvase == 1) {
                    precio = precioFrasco1;
                    cantidadKg = 1000;

                }

                if (tamanioEnvase == 2) {
                    precio = precioFrasco2;
                    cantidadKg = 2000;
                }

                totalFrascosGratis = cantidad / 10;
                descuento = totalFrascosGratis * precio;

                totalVenta = cantidad * precio;
                totalVenta -= descuento;
                totalVentasFrasco += totalVenta;
            }

            // Cálculo de Kg Vendidos
            totalKgVendidos += totalKgVendidos + (cantidadKg * cantidad);

            totalVenta -= descuento;
            c.println("Total Venta: $" + totalVenta);
        }

        c.println("Resultados: ");
        c.println("Bolsas Vendidas: " + bolsasVendidas);
        c.println("Frascos Vendidos: " + frascosVendidos);
        c.println("Kg Vendidos: " + totalKgVendidos);
        c.println("Ventas Totales Bolsa: " + totalVentasBolsa);
        c.println("Ventas Totales Frasco: " + totalVentasFrasco);
        c.println("Total Frascos Gratis: " + totalFrascosGratis);

        if (bolsasVendidas > frascosVendidos) {
            c.println("Se vendieron más bolsas.");
        } else if (bolsasVendidas == frascosVendidos) {
            c.println("Se vendieron la misma cantidad de bolsas y frascos.");
        } else {
            c.println("Se vendieron más frascos.");
        }
    }

    /*
     * Leer N números desde pantalla (N leído como primer dato) y entregar el promedio
     * de los números ignorando el mayor, el menor y los múltiplos de 7 
     * para el cálculo.
     *
     */
    public static void ejercicio02() {
        c.println("Ingrese la cantidad de números:");
        int cantidad = c.readInt();
        int mayor = -9999999;
        int menor = 9999999;

        int contador = 0;
        int suma = 0;

        for (int i = 1; i <= cantidad; i++) {
            c.println("Ingrese un número:");
            int numero = c.readInt();

            if (numero % 7 != 0) {

                if (numero > mayor) {
                    mayor = numero;
                }

                if (numero < menor) {
                    menor = numero;
                }

                suma += numero;
                contador++;
            }

        }

        suma = suma - mayor - menor; // Elimina el mayor y el menor
        contador = contador - 2;

        int promedio = suma / contador;
        c.println("El promedio es: " + promedio);
        if (contador > 0) {
            promedio = suma / contador;
            c.println("El promedio es: " + promedio);
        } else {
            c.println("Insuficientes Valores.");
        }

        c.println("El mayor es: " + mayor);
        c.println("El menor es: " + menor);
        c.println("La suma es: " + suma);
        c.println("La cantidad es: " + contador);

    }

    /*
     * Se desea realzar el cálculo del envío de un producto 
     * desde el extranjero por correo, para ello se solicita 
     * la siguiente información: Monto de la mercadería ( en dólares), ancho, alto, largo (en cm) y peso de la encomienda (en kg). 
     * El cobro es el mayor entre el peso de la mercadería y el peso volumétrico
     * el que se calcula con la siguiente fórmula:
     * PV=Largo(cm)xAncho(cm)xAlto(cm)/6000. 
     * Una vez calculado el peso se aplica la siguiente tabla: 
     *
     * Kilos     * Valor Flete US$
     * 0.5       * 7.70 
     * 1.0       * 8.25 
     * 1.5       * 11.55 
     * 2.0       * 15.40 
     * 2.5       * 19.25 
     * 3.0       * 23.10   
     *                                       
     * Sobre 3 KG son US$3.5 por cada 0.5 KG adicional.
     * Finalmente se le agrega el iva sobre valor de la mercadería (!9%) 
     * y un 3.3% de recargo por combustible.
     *
     * Considere el dolar como $600.
     * Entregar el costo de envío en pesos chilenos de la mercadería.
     *
     */
    public static void ejercicio3() {
        double rango = 0.5;
        double valorAdicional = 3.5;
        double limite = 3;
        double iva = 0.19;
        double impuestoCombustible = 0.033; // 3.3%
        int valorDolar = 500;

        c.println("Ingrese el valor de la mercadería (U$): ");
        int valorMercaderia = c.readInt();

        c.println("Ingrese el peso real (Kg): ");
        double pesoReal = c.readDouble();

        c.println("Ingrese el ancho (cm): ");
        int ancho = c.readInt();

        c.println("Ingrese el alto (cm): ");
        int alto = c.readInt();

        c.println("Ingrese el largo (cm): ");
        int largo = c.readInt();

        // Fórmula: PV=Largo(cm)xAncho(cm)xAlto(cm)/6000. 
        double pesoVolumetrico = (ancho * alto * largo) / 6000;

        c.println("Peso Real: " + pesoReal);
        c.println("Peso Volumétrico: " + pesoVolumetrico);

        double pesoFinal = pesoReal;

        if (pesoReal < pesoVolumetrico) {
            pesoFinal = pesoVolumetrico;
        }
        c.println("Peso a utilizar: " + pesoFinal);

        // Cálculo de Kg adicionales.
        double cobroAdicional = 0;

        if (pesoFinal > 3) {
            double pesoAdicional = pesoFinal - limite;
            int adicional = (int) (pesoAdicional / rango) + 1;
            cobroAdicional = adicional * valorAdicional;
        }

        double valorFlete = 0;
        if (pesoFinal < 0.5) {
            valorFlete = 7.70;
        } else if (pesoFinal < 1) {
            valorFlete = 8.25;
        } else if (pesoFinal < 1.5) {
            valorFlete = 11.55;
        } else if (pesoFinal < 2.0) {
            valorFlete = 15.40;
        } else if (pesoFinal < 2.5) {
            valorFlete = 19.25;
        } else {
            valorFlete = 23.10;
        }

        double totalFlete = valorFlete + cobroAdicional;
        //c.println("Valor Flete: " + valorFlete);
        //c.println("Valor Adicional: " + cobroAdicional);

        double valorIVA = valorMercaderia * iva;
        double valorImpuestoCombustible = valorMercaderia * impuestoCombustible;

        c.println("------------------------------------------");
        c.println("Valor Mercadería (U$): " + valorMercaderia);
        c.println("Total Flete (U$): " + totalFlete);
        c.println("IVA (U$): " + valorIVA);
        c.println("Impuesto Combustible (U$): " + valorImpuestoCombustible);

        double totalEnvioDolares = totalFlete + valorIVA + valorImpuestoCombustible;
        int totalEnvioPesos = (int) (totalEnvioDolares * valorDolar);

        c.println("\nTotal Envío (U$): " + totalEnvioDolares);
        c.println("\nTotal Envío ($): " + totalEnvioPesos);

    }
}
