public class Aplicacion {
    static void main() {
        Restaurante restaurante= new Restaurante("Sabor & Tradición", 123, "Armenia, Quindío");

        Cliente cliente1= new Cliente(456, "Ana", "23456", "ana@gmail.com", "Calle 48");
        Cliente cliente2= new Cliente(789, "Juan", "34575", "juan@gmail.com", "Carrera 19");

        Producto plato1= new PlatoFuerte(001, "Carne Asada", "Corte de res jugoso asado al carbón con yuca y hogao", 25000, 25, 450, true, TipoPreparacion.ASADO);
        Producto plato2= new PlatoFuerte(002, "Pechuga Horneada a las Finas Hierbas", "Pechuga jugosa al horno acompañada de puré de papa", 22000, 30, 350, true, TipoPreparacion.HORNEADO);

        Producto bebida1= new Bebida(003, "Limonada de Hierbabuena", "Limonada refrescante natural frappé a base de hierbabuena", 6000, 5, 400, 5, false, TipoBebida.FRIA);
        Producto bebida2= new Bebida(004, "Chocolate con Queso", "Chocolate espeso artesanal preparado en leche", 8000, 8, 300, 65, true, TipoBebida.CALIENTE);

        Producto postre1= new Postre(005, "Torta Tres Leches", "Ponqué esponjoso bañado en mezcla de tres leches", 8000, 10, 200, 4, true);
        Producto postre2= new Postre(006, "Brevas con Arequipe", "Brevas en almíbar acompañadas de arequipe tradicional", 7000, 5, 150, 22, false);
    }
}
