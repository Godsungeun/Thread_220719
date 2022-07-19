public class Th1 {
    public static void main(String[] args) {

        // 익명 Runnable 구현 객체 활용하여 스레드 생성
        // 스레드타입의 참조변수 thread1에 스레드타입 객체인데 Runnable 익명객체를 넣어줌
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i=0; i <100; i++){
                    System.out.print("#");
                }
            }
        });

        thread1.start();
        for (int i=0; i<100; i++){
            System.out.print("@");
        }
    }
}
