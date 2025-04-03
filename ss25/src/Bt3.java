class Car {
    private final String engine;
    private final int seats;
    private final String color;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.seats = builder.seats;
        this.color = builder.color;
    }

    @Override
    public String toString() {
        return "Car{ engine='" + engine + "', seats=" + seats + ", color='" + color + "' }";
    }

    public static class CarBuilder {
        private String engine;
        private int seats;
        private String color;

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
