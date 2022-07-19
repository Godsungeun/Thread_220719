public class Th2 {
    public static void main(String[] args) {
        //익명 Thread 하위 객체를 활용한 스레드 생성
        //스레드 타입의 참조변수 thread2에 익명의 스레드 객체를 생성
        Thread thread2 = new Thread() {
            public void run() {
                for (int i=0; i<100; i++){
                    System.out.print("#");
                }
            }
        };
        thread2.start();

        for(int i=0; i<100; i++){
            System.out.print("@");
        }
    }
}
