package bt4;

 interface Shape {
     static void description() {
        System.out.println("This is a shape");
    }

    default double area() {
        return 0;
    }

}
