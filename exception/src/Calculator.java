class Calculator {

    double calDouble(int a) {
        if (a == 0) {
            throw new MyArithException("Zero not allowed");
        }
        if (a < 0) {
            throw new MyArithException("negative not allowed");
        }
        return a;
    }
}
