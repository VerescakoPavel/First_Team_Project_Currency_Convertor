public class Curr {

        public String name;
        public float rate;

        public Curr(String name, float rate) {
            this.name = name;
            this.rate = rate;
        }

        public String getName() {
            return name;
        }

        public float getRate() {
            return rate;
        }

        @Override
        public String toString() {
            return "Currency{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

