public class StockAccount
{
    private final String name;
    private double cash;
    private int N;
    private int[] shares;
    private String[] stocks;

    public StockAccount(String name, double cash, int[] shares, String[] stocks) {
        this.name = name;
        this.cash = cash;
        this.shares = shares;
        this.stocks = stocks;
    }
    
    public StockAccount(In in) {
        name = in.readLine();
        cash = in.readDouble();
        N = in.readInt();
        shares = new int[N];
        stocks = new String[N];
        for (int i = 0; i<N; i++) {
            shares[i] = in.readInt();
            stocks[i] = in.readString();
        }
    }

    public void write(Out out) {
        out.println(name);
        out.println(cash);
        out.println(N);
        for (int i = 0; i<N; i++) {
            out.println(shares[i]);
            out.println(stocks[i]);
        }
    }

    public void printReport() {
        StdOut.printf("%s\n", name);
        StdOut.printf("\t\t\tCash: $%9.2f\n", cash);
        double total = cash;
        for (int i = 0; i<N; i++) {
            int amount = shares[i];
             StdOut.printf("%4d %4s ", amount, stocks[i]);
             total += amount;
        }
        StdOut.printf("\t\t\tTotal: $%9.2f\n", total);
    }

    public static void main(String[] args) {
        // int[] shares = new int[2];
        // shares[0] = 100;
        // shares[1] = 25;
        // String[] stocks = new String[2];
        // stocks[0] = "ADBE";
        // stocks[1] = "GOOG";
        // StockAccount sa = new StockAccount("Turing, Alan", 10.24, shares, stocks);
        // Out out = new Out("stock_account.txt");
        // sa.write(out);
        In in = new In("stock_account.txt");
        StockAccount sa = new StockAccount(in);
        sa.printReport();
    }
}

    
