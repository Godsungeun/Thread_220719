public class Thread_current {
    public static void main(String[] args) {
        Thread thread5 = new Thread(new Runnable(){
            public void run() {
                System.out.println(Thread.currentThread().getName());
                //현재 실행중인 스레드의 주소값의. 이름을 호출하여 출력
                //여기서 실행되는 것은 main스레드
            }
        });

        thread5.start();
        System.out.println(Thread.currentThread().getName());
        //여기서 실행되는 것은 0번째 스레드
    }
}
