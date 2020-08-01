package util;
import beans.Product;
import beans.Sale;
import beans.Warehouse;
import beans.WarehouseStock;
import interfaces.IProductSERVICE;
import interfaces.ISaleSERVICE;
import interfaces.IWarehouseSERVICE;
import interfaces.IWarehouseStockSERVICE;
import service.ProductSERVICE;
import service.SaleSERVICE;
import service.WarehouseSERVICE;
import service.WarehouseStockSERVICE;

import java.text.DecimalFormat;
import java.util.*;

public class Launcher {

    public static void main(String[] a){

        //Declaracion de objetos para la totalidad de la ejecucion del programa

        Warehouse warehouse = new Warehouse();
        IWarehouseSERVICE warehouseSERVICE = warehouseSERVICE= new WarehouseSERVICE();
        List<Warehouse> warehouses = null;

        Product product = new Product();
        IProductSERVICE productSERVICE = new ProductSERVICE();
        List<Product> products = null;

        WarehouseStock warehouseStock = new WarehouseStock();
        IWarehouseStockSERVICE warehouseStockSERVICE = new WarehouseStockSERVICE();
        List<WarehouseStock> warehouseStocks = null;

        Sale sale = new Sale();
        ISaleSERVICE saleService = new SaleSERVICE();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestion del almacen");

        int menuOption = 1000;

        while(menuOption != 0){

            System.out.println("PULSE 1 PARA INTRODUCIR LOS ALMACENES");
            System.out.println("PULSE 2 PARA LISTAR LOS ALMACENES");
            System.out.println("PULSE 3 PARA INTRODUCIR LOS PRODUCTOS");
            System.out.println("PULSE 4 PARA LISTAR LOS ALMACENES");
            System.out.println("PULSE 5 PARA INTRODUCIR LOS PRODUCTOS EN LOS ALMACENES");
            System.out.println("PULSE 6 PARA INTRODUCIR LAS VENTAS");
            System.out.println("PULSE 0 PARA SALIR");

            menuOption = scanner.nextInt();

            if(menuOption == 1){
                System.out.println("Vamos a introducir los almacenes....");

                try{
                    String[] cities = {"MADRID", "BARCELONA", "SEVILLA", "LONDRES", "AMSTERDAM", "NUEVA YORK", "HELSINKI", "TALLIN", "BRUJAS", "DUBLIN"};
                    for (int z = 0; z < cities.length; z++){
                        warehouse.setName("ALMACEN_"+(z+1));
                        warehouse.setLocation(cities[z]);
                        warehouseSERVICE.addWarehouse(warehouse);
                    }

                    warehouse = null;
                    System.out.println("ALMACENES INSERTADOS CON EXITO");

                }catch (Exception e){
                    System.out.println("Error al insertar los Almacenes");
                }

            }else if(menuOption == 2){

                System.out.println("Mostrando los almances...");

                warehouses = warehouseSERVICE.listAllWarehouses();
                for (Warehouse war : warehouses){

                    System.out.println("Almacen -> "  + war);
                }

            }else if(menuOption == 3){

                System.out.println("Vamos a introducir los productos...");
                try{
                    DecimalFormat formatDecimal = new DecimalFormat("#.00");
                    for(int z = 1; z <= 100; z++){
                        product.setName("PRODUCTO_"+z);
                        product.setPrice(Double.parseDouble(formatDecimal.format(Math.random()*100)));
                        productSERVICE.addProduct(product);
                    }
                    System.out.println("PRODUCTOS INSERTADOS CON ÉXITO");
                }catch (Exception e){
                    System.out.println("Error al insertar los productos");
                }

            }else if(menuOption == 4){

                System.out.println("Mostrando los productos...");

                products = productSERVICE.listAllProducts();
                for (Product pro : products){

                    System.out.println("Producto -> "  + pro);
                }

            }else if(menuOption == 5){

                System.out.println("Insertando los productos en el almacen");

                try{
                    if(products == null){
                        products = productSERVICE.listAllProducts();
                        //Esto lo hago para tener dos veces cada producto y poder insertarlo en dos almacenes
                        products.addAll(products);
                    }


                    /*
                    Esto es para saber el ID del primer almacen, ya que al ser autoincremental,
                    de normal general, el id ira cambiando, ya que si no seleccionamos alguna opcion del menu que inicialice la lista de los Almacenes(Warehouse)
                    no sabremos cual es el indice del primer almacen.
                     */
                    int indexWarehouse = warehouseSERVICE.getFirstId();

                    for (Product p : products){
                        warehouseStock.setStock((int) Math.floor(Math.random()*(11-1) + 1));
                        warehouseStock.setWarehouse(warehouseSERVICE.findById((int) Math.floor(Math.random()*((indexWarehouse+10) - indexWarehouse) + indexWarehouse)));
                        warehouseStock.setProduct(p);
                        warehouseStockSERVICE.addWarehouse(warehouseStock);

                    }
                    warehouseStock = null;

                    System.out.println("Almacenaje realizado");


                }catch(Exception e){
                    System.out.println("No ha sido posible hacer la insercion de los productos en los almacenes");
                }

            }else if(menuOption == 6){

                System.out.println("Insertando las ventas");

                /*
                 *
                 */
                int indexWarehouseStock = warehouseStockSERVICE.getFirstId();

                try{

                    for(int z = 1; z <= 1000; z++){

                        warehouseStock = warehouseStockSERVICE.findById((int) Math.floor(Math.random()*((indexWarehouseStock+100) - indexWarehouseStock) + indexWarehouseStock));
                        warehouse = warehouseStock.getWarehouse();
                        product = warehouseStock.getProduct();

                        sale.setProduct(product);
                        sale.setWarehouse(warehouse);
                        sale.setSaleDate(setDateSel());
                        saleService.addSale(sale);
                    }

                    System.out.println("VENTAS REALIZADAS");


                }catch(Exception e){
                    System.out.println("No ha sido posible insertar las ventas");
                }




            }else if(menuOption == 0){
                System.out.println("Pulsado 0....");
                break;
            }


        }


    }

    private static Calendar setDateSel(){

        Calendar calendar = new GregorianCalendar();

        int year = (int) Math.floor(Math.random()*(2014-2021+1) + 2021);

        int limit = 31;

        int month = (int) Math.floor(Math.random()*((0+11) - 0) + 0);
        switch (month) {
            case 1:
                if(year == 2016 || year == 2020){
                    limit = 29;
                }else{
                    limit = 28;
                }

            case 3:
                limit = 30;

            case 5:
                limit = 30;

            case 8:
                limit = 30;

            case 10:
                limit = 30;
        }

        int day = (int) Math.floor(Math.random()*((0+limit) - 0) + 0);

        calendar.set(year, month, day);

        return calendar;
    }


}
