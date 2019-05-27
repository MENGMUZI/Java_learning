/**
 * @author : mengmuzi
 * create at:  2019-05-23  02:32
 * @description: 家庭收支小程序
 */
public class FamilyAccount {

    public static void main(String[] args) {
        boolean isFlag = true;
        String details ="";//记录用户的收入和支出
        int balance = 10000;
        while (isFlag){
            System.out.println("-----------------家庭收支记账软件-----------------");
            System.out.println("                   1 收支明细");
            System.out.println("                   2 登记收入");
            System.out.println("                   3 等级支出");
            System.out.println("                   4 退   出");
            System.out.print("                   请选择（1-4）：");
            //获取用户的选择
            char selection = Utility.readMenuSelection();
            switch (selection){
                case '1':
                    //System.out.println("1.收支明细");
                    System.out.println("-----------------当前收支明细记录-----------------\n");
                    System.out.println("收支\t账户金额\t收支金额\t说  明\n");
                    System.out.println(details);
                    System.out.println("-----------------------------------------------\n");

                    break;
                case '2':
                    //System.out.println("2.登记收入");
                    System.out.print("本次收入金额：");
                    int addmoney = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String addinfo = Utility.readString();
                    //处理balance
                    balance += addmoney;
                    //处理details
                    details += ("收入\t" + balance + "  \t" + addmoney + "  \t" + addinfo +"\n");
                    System.out.println("-----------------登记完成-----------------\n");
                    break;
                case '3':
                    //System.out.println("3.登记支出");
                    System.out.print("本次支出金额：");
                    int minusmoney = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String minusinfo = Utility.readString();
                    //处理balance
                    if(balance >= minusmoney){
                        balance -= minusmoney;
                        details += ("支出\t" + balance + "  \t" + minusmoney + "  \t" + minusinfo +"\n");
                    }else {
                        System.out.println("账户被掏空");
                    }
                    System.out.println("-----------------登记完成-----------------\n");
                    break;
                case '4':
                    //System.out.println("4.退出");
                    System.out.print("确认是否退出（Y/N）：");
                    char isExit = Utility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                    }
                    // break;
            }



        }

    }

}
