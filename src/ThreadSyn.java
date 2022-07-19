public class ThreadSyn {
    public static void main(String[] args) {
        Runnable threadTask3 = new ThreadTask3();
        Thread thread3_1 = new Thread(threadTask3);
        Thread thread3_2 = new Thread(threadTask3);

        thread3_1.setName("김코딩");
        thread3_2.setName("박자바");

        thread3_1.start();
        thread3_2.start();
    }
}
class Account{
    //잔액을 나타내는 변수
    private int balance = 1000;
    public int getBalance(){
        return balance;
    }
    //인출 성공시 true, 실패시 false 반환하는 메서드 정의
    public boolean withdraw(int money){
        //인출 가능 여부 판단 : 잔액이 인출하고자 하는 금액보다 같거나 많아야함
        if (balance >= money){
            //if문의 실행부에 진익하자마자 해당 스레들르 일시 정지
            //다른 스레드에게 제어권을 강제로 넘긴다
            //일부러 문제 상황을 발생시키려고 넣은 코드임
            try {Thread.sleep(1000); } catch(Exception error){}

            //잔액에서 인출금을 깎아 새로운 잔액을 기록
            balance -= money;
            return true;
        }
        return false; // 잔액이 인출액보다 적으면 false
    }
}
class ThreadTask3 implements Runnable{
    Account account = new Account();

    public void run() {
        while (account.getBalance() >0){ //잔액이 남아있는동안 실행
            //100~300원의 인출금을 랜덤으로 정한다
            int money = (int)(Math.random() * 3 +1) * 100;
            //withdraw를 실행시키는 동시에 인출 성공 여부를 변수에 할당
            boolean denied = !account.withdraw(money);

            //인출결과 확인
            //만약 withdraw가 false를 리턴하면(인출에 실패했다면)
            //해당 내역에 -> DENIED를 출력한다
            System.out.println(String.format("Wiwhdraw %d| by %s, balance : %d %s ",
                    money, Thread.currentThread().getName(),account.getBalance(), denied ? "-> DENIED" : ""));
            //삼항연산자 denied가 true면 ?우측 __실행, false는면 :우측 __실행
        }
    }
}
