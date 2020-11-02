public class EightQueens {
    public int[] results = new int[8];
    public static void main(String[] args) {
         //下标表示行，值表示列
        EightQueens eq = new EightQueens();
        eq.callQueens(0);
    }

    private void callQueens(int row) {
        /**
         * 1.边界判断，行数到8，结束递归
         * 2.每行选择性判断
         * 3.递归
         */
        if (row == 8) {
            printQueens(results);
            return;
        }
        for (int column=0; column<8; ++column) { //每一行八种方法，一一判断
            if(isOk(row, column)) {
                results[row] = column;  //放棋子
                callQueens(row+1);  //递归下一行
            }
        }

    }

    private void printQueens(int[] results) {
        for(int row=0; row<8; ++row){
            for(int column=0; column<8; ++column){
                if(results[row] == column) {
                    System.out.print("Q");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isOk(int row, int column) {
        int leftColumn = column - 1;  //左对角线的值校验
        int rightColumn = column + 1;  //右对角线的值校验
        for(int i=row-1; i>=0; --i) {  //逐行向上考察
            if( results[i] == column ) return false; //行校验
            if( leftColumn >= 0 && results[i] == leftColumn ) return false; //左斜线校验
            if( rightColumn < 8 && results[i] == rightColumn ) return false;
            --leftColumn; ++rightColumn;
        }
        return true;
    }
}
