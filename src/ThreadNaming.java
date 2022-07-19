public class ThreadNaming {
    public static void main(String[] args) {
        Thread thread4 = new Thread(new Runnable() {
            public void run(){
                System.out.println("Set And Get Thread Name");
            }
        });

        thread4.start();
        //이름 바꾸기 전 기존의 이름
        System.out.println("thread4.getName() = " + thread4.getName());

        // setName 메서드("___")로 이름 설정하기
        thread4.setName("Code States");
        // 설정한 이름 확인
        System.out.println("thread4.getName() = " + thread4.getName());
    }
}
