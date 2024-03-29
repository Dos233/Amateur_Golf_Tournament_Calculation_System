import dnl.utils.text.table.TextTable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GolfScoreSystem extends JFrame {
    private static List customers = new ArrayList();
    private static Object[][] colorIndexPar = {{1,521,484,461,3,5},{2,329,298,265,15,4},{3,376,348,315,9,4}
            ,{4,366,352,337,13,4},{5,480,458,443,5,5},{6,209,191,163,11,3},{7,380,356,331,1,4},{8,179,149,139,17,3}
            ,{9,384,329,293,7,4},{10,297,284,256,12,4},{11,387,357,332,2,4},{12,132,124,109,18,3},{13,471,446,392,6,5}
            ,{14,187,156,132,16,3},{15,359,339,317,10,4},{16,338,317,300,14,4},{17,481,460,422,8,5},{18,352,329,293,4,4}};
    public GolfScoreSystem(String applicationTitle,String chartTitle) {
        super(chartTitle);
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Customer",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane(chartPanel);
    }
    public GolfScoreSystem(String chartTitle){
        super(chartTitle);
        JTextField TextField1;
        Object[][] datas=new Object[18][12];
        Customer[] customers1=new Customer[customers.size()];
        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }
        if (customers1.length==0) {
            datas = colorIndexPar;
        }
        if (customers1.length==1) {
            for (int i=0;i<colorIndexPar.length;i++){
                datas[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2], colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5], customers1[0].getHole_scores()[i]};
            }
        }
        if (customers1.length==2) {
            for (int i=0;i<colorIndexPar.length;i++){
                datas[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2], colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5], customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i]};
            }
        }
        if (customers1.length==3) {
            for (int i=0;i<colorIndexPar.length;i++){
                datas[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2], colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5], customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i],customers1[2].getHole_scores()[i]};
            }
        }
        if (customers1.length==4) {
            for (int i=0;i<colorIndexPar.length;i++){
                datas[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2], colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5], customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i],customers1[2].getHole_scores()[i],customers1[3].getHole_scores()[i]};
            }
        }
        if (customers1.length==5) {
            for (int i=0;i<colorIndexPar.length;i++){
                datas[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2], colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5], customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i],customers1[2].getHole_scores()[i],customers1[3].getHole_scores()[i],customers1[4].getHole_scores()[i]};
            }
        }
        if (customers1.length==6) {
            for (int i=0;i<colorIndexPar.length;i++){
                datas[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2], colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5], customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i],customers1[2].getHole_scores()[i],customers1[3].getHole_scores()[i],customers1[4].getHole_scores()[i],customers1[5].getHole_scores()[i]};
            }
        }
        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }

        String[] titles = {"No.","BLUE","WHITE","RED","Index","PAR","A","B","C","D","E","F"};
        DefaultTableModel model = new DefaultTableModel(datas, titles);
        JTable table = new JTable(model);
        DefaultTableCellRenderer ter = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value, boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                if (column == 0) {
                    setBackground(Color.GRAY);
                }
                else if (column == 1) {
                    setBackground(Color.BLUE);
                }
                else if (column == 2) {
                    setBackground(Color.WHITE);
                }
                else if (column == 3) {
                    setBackground(Color.RED);
                }
                else if (column == 4) {
                    setBackground(Color.YELLOW);
                }

                return super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);
            }

        };
        for (int i = 0; i <= 3; i++) {
            table.getColumn(titles[i]).setCellRenderer(ter);
        }
        final JButton updateButton = new JButton("Update");
        final JPanel panel = new JPanel();
        panel.setSize(800,600);
        getContentPane().add(panel,BorderLayout.SOUTH);
        panel.add(new JLabel("Value: "));
        TextField1 = new JTextField("",10);
        panel.add(TextField1);
        updateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int selectedRow = table.getSelectedRow();
                int selectedColumn = table.getSelectedColumn();
                if(selectedRow!= -1){
                    table.setValueAt(TextField1.getText(),selectedRow, selectedColumn);
                    if (selectedColumn<6) {
                        colorIndexPar[selectedRow][selectedColumn] = TextField1.getText();
                    }else if (selectedColumn>=6&&selectedColumn<(6+customers1.length)) {
                        Customer[] customers1=new Customer[customers.size()];
                        for (int i=0;i<customers.size();i++){
                            customers1[i]=(Customer)customers.get(i);
                        }
                        int[] temp = customers1[selectedColumn-6].getHole_scores();
                        temp[selectedColumn-6]=Integer.parseInt(TextField1.getText());
                        customers1[selectedColumn-6].setHole_scores(temp);
                        customers.set(6-selectedColumn,customers1[selectedColumn-6]);
                    }
                }
            }
        });
        setTableHeaderColor(table,0,Color.GRAY);
        setTableHeaderColor(table,1,Color.BLUE);
        setTableHeaderColor(table,2,Color.WHITE);
        setTableHeaderColor(table,3,Color.RED);
        setTableHeaderColor(table,4,Color.YELLOW);
        setTableHeaderColor(table,5,Color.BLACK);
        panel.add(updateButton);
        table.setShowGrid(true);
        add(new JScrollPane(table));
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String club = "";
        String gender = "";
        String handicap = "";
        int serial_number = 0;
        System.out.println("=== Welcome to amateur Golf tournament system ===");
        loopChoice:
        for (int a=0;a<20;a++){
                loopManager:
                for (int i=0;i<20;i++){
                    System.out.println("===================");
                    System.out.println("1. Enter customer Info");
                    System.out.println("2. View customers' hole scores in console");
                    System.out.println("3. View customers' gross scores in console");
                    System.out.println("4. View customers' net scores in console");
                    System.out.println("5. View handicap of the day calculation");
                    System.out.println("6. View net scores of the day calculation");
                    System.out.println("7. View the point table of different handicap type");
                    System.out.println("8. View customer profile in console");
                    System.out.println("9. Generate total results' bar chart for all customer");
                    System.out.println("10. Generate the score chart in detail");
                    System.out.println("11. Exit the program");
                    System.out.println("===================");

                    // male - 24, female - 36
                    try {
                        System.out.printf("Please input serial number (e.g. 1,2) to obtain service: ");
                        serial_number = scanner.nextInt();
                        switch (serial_number){
                            case 1:
                                enterCustomerProfile(name,club,gender,handicap);
                                break;
                            case 2:
                                viewCustomerScores();
                                break;
                            case 3:
                                viewCustomerGrossScores();
                                break;
                            case 4:
                                viewCustomerNetScore();
                                break;
                            case 5:
                                viewHandicapCalculation();
                                break;
                            case 6:
                                viewNetScoreOfDayCalculation();
                                break;
                            case 7:
                                printPointTables();
                                break;
                            case 8:
                                viewCustomerProfile();
                                break;
                            case 9:
                                GolfScoreSystem chart = new GolfScoreSystem("Bar Chart","Total Calculation bar Chart");
                                chart.pack();
                                chart.setVisible( true );
                                break;
                            case 10:
                                GolfScoreSystem chart1 = new GolfScoreSystem("Scores chart");
                                break;
                            case 11:
                                System.out.printf("Do you really want to exit the program? y/n: ");
                                String choice_exit1 = scanner.nextLine();
                                String choice_exit = scanner.nextLine();
                                if (choice_exit.equals("Y") || choice_exit.equals("y")){
                                    System.exit(0);
                                }
                                break;
                            default:
                                System.out.println("Please input correct number to continue!");
                                break;
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                        continue;
                    }
                }
        }
    }

    public static void printPointTables(){
        Scanner scanner = new Scanner(System.in);
        // int active_score = 0;
        Object[][] customerScores=new Object[customers.size()][21];
        Object[][] customerScores1=new Object[customers.size()][21];
        Object[][] customerScores2=new Object[customers.size()][22];
        String[] columnNames = new String[21];
        String[] columnNames2 = new String[22];
        Customer[] customers1=new Customer[customers.size()];
        columnNames[0]= "No.";
        columnNames[1]= "Name";
        columnNames[20]= "Total_Point";

        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }

        if (customers1.length != 0){
            for (int x=0;x<customers1.length;x++) {
                int total_point = 0;
                int total_point1 = 0;
                int total_point2 = 0;
                int total_point3 = 0;
                int sumHandicap = 0;
                //System.out.println("Customer length: "+customers1.length);
                for (int a=0;a<18;a++) {
                    int temp = customers1[x].getHole_scores()[a]-Integer.parseInt(colorIndexPar[a][5].toString());
                    if (temp>=2) {
                        sumHandicap+=0;
                    }else if (temp<=0){
                        sumHandicap+=2;
                    }else if (temp==1){
                        sumHandicap+=1;
                    }
                }
                //System.out.println("sumHandicap: "+sumHandicap);
                /*if (customers1[x].getGender().equals("m")){
                    if (sumHandicap>24){
                        sumHandicap = 24;
                    }
                }else if (customers1[x].getGender().equals("f")){
                    if (sumHandicap>36){
                        sumHandicap = 36;
                    }
                }*/
                int temp = 36-sumHandicap;
                /*System.out.println("temp: "+temp);
                System.out.println("gender: "+customers1[x].getGender());*/
                if (customers1[x].getGender().equals("m")){
                    if (temp>24){
                        temp = 24;
                    }
                }else if (customers1[x].getGender().equals("f")){
                    if (temp>36){
                        temp = 36;
                    }
                }
                /*customerScores[2+x][20] = temp;
                columnNames[20] = "Handicap";*/

                if (temp == 0){
                    int active_score = 0;
                    int discount = 0;
                    for (int y=0;y<18;y++){
                        active_score = customers1[x].getHole_scores()[y] - discount;
                        int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                        total_point += getPoint(mid_number);
                        customerScores[x][y+2] = getPoint(mid_number);
                    }
                    customerScores[x][20] = total_point;
                }else if (temp>=1 && temp<=18){
                    int active_score = 0;
                    int discount = 0;
                    for (int y=0;y<18;y++){
                        if (temp>=Integer.parseInt(colorIndexPar[y][4].toString())){
                            discount = 1;
                        }else {
                            discount = 0;
                        }
                        active_score = customers1[x].getHole_scores()[y] - discount;
                        int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                        total_point += getPoint(mid_number);
                        customerScores[x][y+2] = getPoint(mid_number);
                    }
                    customerScores[x][20] = total_point;
                }else if (temp>=19 && temp<=36){
                    int active_score = 0;
                    int discount = 0;
                    for (int y=0;y<18;y++){
                        if ((temp-18)>=Integer.parseInt(colorIndexPar[y][4].toString())){
                            discount = 2;
                        }else {
                            discount = 1;
                        }
                        active_score = customers1[x].getHole_scores()[y] - discount;
                        int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                        total_point += getPoint(mid_number);
                        customerScores[x][y+2] = getPoint(mid_number);
                    }
                    customerScores[x][20] = total_point;
                }

                if (Integer.parseInt(customers1[x].getHandicap()) == 0){
                    int active_score = 0;
                    int discount = 0;
                    for (int y=0;y<18;y++){
                        active_score = customers1[x].getHole_scores()[y] - discount;
                        int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                        total_point1 += getPoint(mid_number);
                        customerScores1[x][y+2] = getPoint(mid_number);
                    }
                    customerScores1[x][20] = total_point1;
                }else if (Integer.parseInt(customers1[x].getHandicap())>=1 && Integer.parseInt(customers1[x].getHandicap())<=18){
                    int active_score = 0;
                    int discount = 0;
                    for (int y=0;y<18;y++){
                        if (Integer.parseInt(customers1[x].getHandicap())>=Integer.parseInt(colorIndexPar[y][4].toString())){
                            discount = 1;
                        }else {
                            discount = 0;
                        }
                        active_score = customers1[x].getHole_scores()[y] - discount;
                        int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                        total_point1 += getPoint(mid_number);
                        customerScores1[x][y+2] = getPoint(mid_number);
                    }
                    customerScores1[x][20] = total_point1;
                }else if (Integer.parseInt(customers1[x].getHandicap())>=19 && Integer.parseInt(customers1[x].getHandicap())<=36){
                    int active_score = 0;
                    int discount = 0;
                    for (int y=0;y<18;y++){
                        if ((Integer.parseInt(customers1[x].getHandicap())-18)>=Integer.parseInt(colorIndexPar[y][4].toString())){
                            discount = 2;
                        }else {
                            discount = 1;
                        }
                        active_score = customers1[x].getHole_scores()[y] - discount;
                        int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                        total_point1 += getPoint(mid_number);
                        customerScores1[x][y+2] = getPoint(mid_number);
                    }
                    customerScores1[x][20] = total_point1;
                }

                // Modify the best one
                if (temp < Integer.parseInt(customers1[x].getHandicap())){
                    if (temp == 0){
                        int active_score = 0;
                        int discount = 0;
                        for (int y=0;y<18;y++){
                            active_score = customers1[x].getHole_scores()[y] - discount;
                            int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                            total_point2 += getPoint(mid_number);
                            customerScores2[x][y+2] = getPoint(mid_number);
                        }
                        customerScores2[x][20] = total_point2;
                        customerScores2[x][21] = "Handicap of the Day";
                    }else if (temp>=1 && temp<=18){
                        int active_score = 0;
                        int discount = 0;
                        for (int y=0;y<18;y++){
                            if (temp>=Integer.parseInt(colorIndexPar[y][4].toString())){
                                discount = 1;
                            }else {
                                discount = 0;
                            }
                            active_score = customers1[x].getHole_scores()[y] - discount;
                            int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                            total_point2 += getPoint(mid_number);
                            customerScores2[x][y+2] = getPoint(mid_number);
                        }
                        customerScores2[x][20] = total_point2;
                        customerScores2[x][21] = "Handicap of the Day";
                    }else if (temp>=19 && temp<=36){
                        int active_score = 0;
                        int discount = 0;
                        for (int y=0;y<18;y++){
                            if ((temp-18)>=Integer.parseInt(colorIndexPar[y][4].toString())){
                                discount = 2;
                            }else {
                                discount = 1;
                            }
                            active_score = customers1[x].getHole_scores()[y] - discount;
                            int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                            total_point2 += getPoint(mid_number);
                            customerScores2[x][y+2] = getPoint(mid_number);
                        }
                        customerScores2[x][20] = total_point2;
                        customerScores2[x][21] = "Handicap of the Day";
                    }
                }else{
                    if (Integer.parseInt(customers1[x].getHandicap()) == 0){
                        int active_score = 0;
                        int discount = 0;
                        for (int y=0;y<18;y++){
                            active_score = customers1[x].getHole_scores()[y] - discount;
                            int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                            total_point3 += getPoint(mid_number);
                            customerScores2[x][y+2] = getPoint(mid_number);
                        }
                        customerScores2[x][20] = total_point3;
                        customerScores2[x][21] = "Club Handicap";
                    }else if (Integer.parseInt(customers1[x].getHandicap())>=1 && Integer.parseInt(customers1[x].getHandicap())<=18){
                        int active_score = 0;
                        int discount = 0;
                        for (int y=0;y<18;y++){
                            if (Integer.parseInt(customers1[x].getHandicap())>=Integer.parseInt(colorIndexPar[y][4].toString())){
                                discount = 1;
                            }else {
                                discount = 0;
                            }
                            active_score = customers1[x].getHole_scores()[y] - discount;
                            int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                            total_point3 += getPoint(mid_number);
                            customerScores2[x][y+2] = getPoint(mid_number);
                        }
                        customerScores2[x][20] = total_point3;
                        customerScores2[x][21] = "Club Handicap";
                    }else if (Integer.parseInt(customers1[x].getHandicap())>=19 && Integer.parseInt(customers1[x].getHandicap())<=36){
                        int active_score = 0;
                        int discount = 0;
                        for (int y=0;y<18;y++){
                            if ((Integer.parseInt(customers1[x].getHandicap())-18)>=Integer.parseInt(colorIndexPar[y][4].toString())){
                                discount = 2;
                            }else {
                                discount = 1;
                            }
                            active_score = customers1[x].getHole_scores()[y] - discount;
                            int mid_number = active_score - Integer.parseInt(colorIndexPar[y][5].toString());
                            total_point3 += getPoint(mid_number);
                            customerScores2[x][y+2] = getPoint(mid_number);
                        }
                        customerScores2[x][20] = total_point3;
                        customerScores2[x][21] = "Club Handicap";
                    }
                }


                customerScores[x][0]= x+1;
                customerScores[x][1]= customers1[x].getName();
                customerScores1[x][0]= x+1;
                customerScores1[x][1]= customers1[x].getName();
                customerScores2[x][0]= x+1;
                customerScores2[x][1]= customers1[x].getName();

                if (x==0) {
                    for (int j = 0; j < 18; j++) {
                        columnNames[2 + j] = "Hole_" + (j + 1);
                    }
                    for (int i = 0; i < columnNames.length; i++){
                        columnNames2[i] = columnNames[i];
                    }
                    columnNames2[21] = "Type of the handicap";
                }


            }
        }
        System.out.printf("Which point table do you want? c (Handicap of the Day)/ t (Club Handicap) /m (Modify the Best One): ");
        String choice_table = scanner.nextLine();
        for (int a=0;a<100;a++){
            if (choice_table.equals("c")){
                System.out.println("\n========== Point: Handicap of the Day ==========");
                TextTable resultTable1 = new TextTable(columnNames,customerScores);
                resultTable1.printTable();
                break;
            }else if (choice_table.equals("t")){
                System.out.println("\n========== Point: Club Handicap ==========");
                TextTable resultTable2 = new TextTable(columnNames,customerScores1);
                resultTable2.printTable();
                break;
            }else if (choice_table.equals("m")){
                System.out.println("\n========== Modify the best one ==========");
                TextTable resultTable3 = new TextTable(columnNames2,customerScores2);
                resultTable3.printTable();
                break;
            }else {
                System.out.println("Please enter valid choice!");
                break;
            }
        }
        System.out.println();
    }

    public static int getPoint(int mid_number){
        int point = 0;
        if (mid_number<=1){
            point = Math.abs(mid_number - 2);
        }else {
            point = 0;
        }
        return point;
    }

    public static void viewNetScoreOfDayCalculation(){
        Customer[] customers1=new Customer[customers.size()];
        Object[][] customerScores2=new Object[customers.size()][5];
        String[] columnNames2 = {"No.","Name","Gross","Handicap","Net-Score"};
        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }
        int[] storePosition2 = new int[customers.size()];
        int[] dummyArray2 = new int[customers.size()];

        for (int i=0;i<customers.size();i++){
            if (i==0){
                for (int x=0;x<customers.size();x++){
                    dummyArray2[x]=customers1[x].getTotal_result()-Integer.parseInt(customers1[x].getHandicap());
                    storePosition2[x]=x;
                }
            }
            for (int b=i+1;b<customers.size();b++){
                if (dummyArray2[i]>dummyArray2[b]){
                    int temp=dummyArray2[i];
                    dummyArray2[i]=dummyArray2[b];
                    dummyArray2[b]=temp;
                    int temp1=storePosition2[i];
                    storePosition2[i]=storePosition2[b];
                    storePosition2[b]=temp1;

                }
            }
        }

        int[] handicapOfDay = new int[customers1.length];
        for (int x=0;x<customers1.length;x++) {
            int sumHandicap = 0;
            //System.out.println("Customer length: "+customers1.length);
            for (int a = 0; a < 18; a++) {
                int temp1 = customers1[x].getHole_scores()[a] - Integer.parseInt(colorIndexPar[a][5].toString());
                if (temp1 >= 2) {
                    sumHandicap += 0;
                } else if (temp1 <= 0) {
                    sumHandicap += 2;
                } else if (temp1 == 1) {
                    sumHandicap += 1;
                }
            }
            /*if (customers1[x].getGender().equals("m")){
                if (sumHandicap>24){
                    sumHandicap = 24;
                }
            }else if (customers1[x].getGender().equals("f")){
                if (sumHandicap>36){
                    sumHandicap = 36;
                }
            }*/
            //System.out.println("sumHandicap: "+sumHandicap);
            int temp = 36-sumHandicap;
            if (customers1[x].getGender().equals("m")){
                if (temp>24){
                    temp = 24;
                }
            }else if (customers1[x].getGender().equals("f")){
                if (temp>36){
                    temp = 36;
                }
            }
            handicapOfDay[x] = temp;
        }

        for (int i=0;i<customers.size();i++){
            customerScores2[i]= new Object[]{(i+1), customers1[storePosition2[i]].getName(), customers1[storePosition2[i]].getTotal_result(),handicapOfDay[i],customers1[storePosition2[i]].getTotal_result()-handicapOfDay[i]};
            //customerScores2[i]= new Object[]{i, customers1[i].getName(), customers1[i].getTotal_result(),Integer.parseInt(customers1[i].getHandicap()),customers1[i].getTotal_result()-Integer.parseInt(customers1[i].getHandicap())};
        }
        TextTable resultTable2 = new TextTable(columnNames2,customerScores2);
        resultTable2.printTable();
    }

    public static void viewHandicapCalculation(){
        Object[][] customerScores=new Object[customers.size()+2][21];
        String[] columnNames = new String[21];
        Customer[] customers1=new Customer[customers.size()];
        columnNames[0]= "No.";
        columnNames[1]= "Name";

        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }

        for (int i=0;i<customers.size();i++){
            customerScores[2+i][0]= i+1;
            customerScores[2+i][1]= customers1[i].getName();
            customerScores[0][0]="";
            customerScores[1][0]="";
            customerScores[0][1]="Index";
            customerScores[1][1]="Par";

            int counter=0;
            for (int y=2;y<20;y++){
                customerScores[0][y]=colorIndexPar[counter][4];
                customerScores[1][y]=colorIndexPar[counter][5];
                counter++;
            }

            for (int j=0;j<18;j++){
                customerScores[i+2][2+j] = customers1[i].getHole_scores()[j];
                if (i==0){
                    columnNames[2+j] = "H_"+(j+1);
                }
            }

            for (int x=0;x<customers1.length;x++) {
                int sumHandicap = 0;
                //System.out.println("Customer length: "+customers1.length);
                for (int a=0;a<18;a++) {
                    int temp = customers1[x].getHole_scores()[a]-Integer.parseInt(colorIndexPar[a][5].toString());
                    if (temp>=2) {
                        sumHandicap+=0;
                    }else if (temp<=0){
                        sumHandicap+=2;
                    }else if (temp==1){
                        sumHandicap+=1;
                    }
                }
                //System.out.println("sumHandicap: "+sumHandicap);
                /*if (customers1[x].getGender().equals("m")){
                    if (sumHandicap>24){
                        sumHandicap = 24;
                    }
                }else if (customers1[x].getGender().equals("f")){
                    if (sumHandicap>36){
                        sumHandicap = 36;
                    }
                }*/
                int temp = 36-sumHandicap;
                /*System.out.println("temp: "+temp);
                System.out.println("gender: "+customers1[x].getGender());*/
                if (customers1[x].getGender().equals("m")){
                    if (temp>24){
                        temp = 24;
                    }
                }else if (customers1[x].getGender().equals("f")){
                    if (temp>36){
                        temp = 36;
                    }
                }
                customerScores[2+x][20] = temp;
                columnNames[20] = "Handicap";
            }
        }
        /*String[] columnNames = {"No.","Index","Par","A","B","C","D","E","F"};*/
        TextTable resultTable = new TextTable(columnNames,customerScores);
        resultTable.printTable();
    }

    public static void enterCustomerProfile(String name,String club,String gender,String handicap) {
        Scanner scanner = new Scanner(System.in);
        int j;
        Customer[] customers1=new Customer[customers.size()];
        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }

        System.out.printf("Please enter the customer size: ");
        int  customerSize = scanner.nextInt();
        for (int d=0;d<customerSize;d++){
            int sum=0;
            int[] scores = new int[18];
            Customer customer = new Customer();
            String temp = scanner.nextLine();
            System.out.printf("Please enter your name: ");
            name = scanner.nextLine();
            System.out.printf("Please enter your club: ");
            club = scanner.nextLine();
            System.out.printf("Please enter your gender (m[male] / f[female]): ");
            gender = scanner.nextLine();
            System.out.printf("Please enter your handicap: ");
            handicap = scanner.nextLine();

            for (int i=0;i<18;i++){
                j=i+1;
                System.out.printf("Hole_"+j+" score: ");
                scores[i]=scanner.nextInt();
                sum+=scores[i];
            }
            for (int i=0;i<customers.size();i++){
                if (gender.equals("m")){
                    if (Integer.parseInt(handicap)>24){
                        gender = "24";
                    }
                }else if (gender.equals("f")){
                    if (Integer.parseInt(handicap)>36){
                        gender = "36";
                    }
                }
            }
            customer.setHole_scores(scores);
            customer.setName(name);
            customer.setClub(club);
            customer.setGender(gender);
            customer.setHandicap(handicap);
            customer.setTotal_result(sum);
            customers.add(customer);
        }
    }

    public static void viewCustomerScores(){
        Object[][] customerScores=new Object[customers.size()+2][20];
        String[] columnNames = new String[20];
        Customer[] customers1=new Customer[customers.size()];
        columnNames[0]= "No.";
        columnNames[1]= "Name";

        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }

        for (int i=0;i<customers.size();i++){
            customerScores[2+i][0]= i+1;
            customerScores[2+i][1]= customers1[i].getName();
            customerScores[0][0]="";
            customerScores[1][0]="";
            customerScores[0][1]="Index";
            customerScores[1][1]="Par";

               int counter=0;
                for (int y=2;y<20;y++){
                    customerScores[0][y]=colorIndexPar[counter][4];
                    customerScores[1][y]=colorIndexPar[counter][5];
                    counter++;
                }

            for (int j=0;j<18;j++){
                    customerScores[i+2][2+j] = customers1[i].getHole_scores()[j];
                    if (i==0){
                        columnNames[2+j] = "Hole_"+(j+1);
                    }
            }
        }
        /*String[] columnNames = {"No.","Index","Par","A","B","C","D","E","F"};*/
        TextTable resultTable = new TextTable(columnNames,customerScores);
        resultTable.printTable();
    }

    public static void viewCustomerGrossScores(){
        Customer[] customers1=new Customer[customers.size()];
        Object[][] customerScores1=new Object[customers.size()][3];
        String[] columnNames1 = {"No.","Name","Gross"};
        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }


        int[] storePosition = new int[customers.size()];
        int[] dummyArray = new int[customers.size()];
        for (int i=0;i<customers.size();i++){
            if (i==0){
                for (int x=0;x<customers.size();x++){
                    dummyArray[x]=customers1[x].getTotal_result();
                    storePosition[x]=x;
                }
            }
            for (int b=i;b<customers.size();b++){
                if (dummyArray[i]>dummyArray[b]){
                    int temp=dummyArray[i];
                    dummyArray[i]=dummyArray[b];
                    dummyArray[b]=temp;
                    int temp1=storePosition[i];
                    storePosition[i]=storePosition[b];
                    storePosition[b]=temp1;
                }
            }
        }
        for (int i=0;i<customers.size();i++){
            customerScores1[i]= new Object[]{(i+1), customers1[storePosition[i]].getName(), customers1[storePosition[i]].getTotal_result()};
        }
        TextTable resultTable1 = new TextTable(columnNames1,customerScores1);
        resultTable1.printTable();
    }
    public static void viewCustomerNetScore(){
        Customer[] customers1=new Customer[customers.size()];
        Object[][] customerScores2=new Object[customers.size()][5];
        String[] columnNames2 = {"No.","Name","Gross","Handicap","Net-Score"};
        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }
        int[] storePosition2 = new int[customers.size()];
        int[] dummyArray2 = new int[customers.size()];

        for (int i=0;i<customers.size();i++){
            if (i==0){
                for (int x=0;x<customers.size();x++){
                    dummyArray2[x]=customers1[x].getTotal_result()-Integer.parseInt(customers1[x].getHandicap());
                    storePosition2[x]=x;
                }
            }
            for (int b=i+1;b<customers.size();b++){
                if (dummyArray2[i]>dummyArray2[b]){
                    int temp=dummyArray2[i];
                    dummyArray2[i]=dummyArray2[b];
                    dummyArray2[b]=temp;
                    int temp1=storePosition2[i];
                    storePosition2[i]=storePosition2[b];
                    storePosition2[b]=temp1;
                }
            }
        }

        for (int i=0;i<customers.size();i++){
            if (customers1[storePosition2[i]].getGender().equals("m")){
                if (Integer.parseInt(customers1[storePosition2[i]].getHandicap())>24){
                    customers1[storePosition2[i]].setHandicap("24");
                }
            }else if (customers1[storePosition2[i]].getGender().equals("f")){
                if (Integer.parseInt(customers1[storePosition2[i]].getHandicap())>36){
                    customers1[storePosition2[i]].setHandicap("36");
                }
            }
            customerScores2[i]= new Object[]{(i+1), customers1[storePosition2[i]].getName(), customers1[storePosition2[i]].getTotal_result(),Integer.parseInt(customers1[storePosition2[i]].getHandicap()),customers1[storePosition2[i]].getTotal_result()-Integer.parseInt(customers1[storePosition2[i]].getHandicap())};
            //customerScores2[i]= new Object[]{i, customers1[i].getName(), customers1[i].getTotal_result(),Integer.parseInt(customers1[i].getHandicap()),customers1[i].getTotal_result()-Integer.parseInt(customers1[i].getHandicap())};
        }
        TextTable resultTable2 = new TextTable(columnNames2,customerScores2);
        resultTable2.printTable();

    }

    public static void viewCustomerProfile(){
        Customer[] customers1=new Customer[customers.size()];
        for (int i=0;i<customers.size();i++){
            int j=i+1;
            customers1[i]=(Customer)customers.get(i);
            System.out.println("NO.: "+j);
            System.out.println("Name: "+customers1[i].getName());
            System.out.println("Club: "+customers1[i].getClub());
            if (customers1[i].getGender().equals("m")){
                if (Integer.parseInt(customers1[i].getHandicap())>24){
                    customers1[i].setHandicap("24");
                }
            }else if (customers1[i].getGender().equals("f")){
                if (Integer.parseInt(customers1[i].getHandicap())>36){
                    customers1[i].setHandicap("36");
                }
            }
            System.out.println("Handicap: "+customers1[i].getHandicap());
            System.out.println("===================");
        }
    }

    private CategoryDataset createDataset( ) {
        Customer[] customers1=new Customer[customers.size()];
        String cus1,cus2,cus3,cus4,cus5,cus6;
        int value1,value2,value3,value4,value5,value6;
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );
        for (int i=0;i<customers.size();i++) {
            customers1[i] = (Customer) customers.get(i);
        }
        if (customers.size()==0){
            System.out.println("Please enter customer scores!");
        }
        if (customers.size()==1) {
            cus1 = customers1[0].getName();
            value1 = customers1[0].getTotal_result();
            dataset.addValue( value1,customers1[0].getName(), cus1 );
        }
        if (customers.size()==2) {
            cus1 = customers1[0].getName();
            cus2 = customers1[1].getName();
            value1 = customers1[0].getTotal_result();
            value2 = customers1[1].getTotal_result();
            dataset.addValue( value1, customers1[0].getName() , cus1 );
            dataset.addValue( value2, customers1[1].getName() , cus2 );
        }
        if (customers.size()==3) {
            cus1 = customers1[0].getName();
            cus2 = customers1[1].getName();
            cus3 = customers1[2].getName();
            value1 = customers1[0].getTotal_result();
            value2 = customers1[1].getTotal_result();
            value3 = customers1[2].getTotal_result();
            dataset.addValue( value1, customers1[0].getName() , cus1 );
            dataset.addValue( value2, customers1[1].getName() , cus2 );
            dataset.addValue( value3, customers1[2].getName() , cus3);
        }
        if (customers.size()==4) {
            cus1 = customers1[0].getName();
            cus2 = customers1[1].getName();
            cus3 = customers1[2].getName();
            cus4 = customers1[3].getName();
            value1 = customers1[0].getTotal_result();
            value2 = customers1[1].getTotal_result();
            value3 = customers1[2].getTotal_result();
            value4 = customers1[3].getTotal_result();
            dataset.addValue( value1, customers1[0].getName() , cus1 );
            dataset.addValue( value2, customers1[1].getName() , cus2 );
            dataset.addValue( value3, customers1[2].getName() , cus3);
            dataset.addValue( value4, customers1[3].getName() , cus4);
        }
        if (customers.size()==5) {
            cus1 = customers1[0].getName();
            cus2 = customers1[1].getName();
            cus3 = customers1[2].getName();
            cus4 = customers1[3].getName();
            cus5 = customers1[4].getName();
            value1 = customers1[0].getTotal_result();
            value2 = customers1[1].getTotal_result();
            value3 = customers1[2].getTotal_result();
            value4 = customers1[3].getTotal_result();
            value5 = customers1[4].getTotal_result();
            dataset.addValue( value1, customers1[0].getName() , cus1 );
            dataset.addValue( value2, customers1[1].getName() , cus2 );
            dataset.addValue( value3, customers1[2].getName() , cus3);
            dataset.addValue( value4, customers1[3].getName() , cus4);
            dataset.addValue( value5, customers1[4].getName() , cus5);
        }
        if (customers.size()==6) {
            cus1 = customers1[0].getName();
            cus2 = customers1[1].getName();
            cus3 = customers1[2].getName();
            cus4 = customers1[3].getName();
            cus5 = customers1[4].getName();
            cus6 = customers1[5].getName();
            value1 = customers1[0].getTotal_result();
            value2 = customers1[1].getTotal_result();
            value3 = customers1[2].getTotal_result();
            value4 = customers1[3].getTotal_result();
            value5 = customers1[4].getTotal_result();
            value6 = customers1[5].getTotal_result();
            dataset.addValue( value1, customers1[0].getName() , cus1 );
            dataset.addValue( value2, customers1[1].getName() , cus2 );
            dataset.addValue( value3, customers1[2].getName() , cus3);
            dataset.addValue( value4, customers1[3].getName() , cus4);
            dataset.addValue( value5, customers1[4].getName() , cus5);
            dataset.addValue( value6, customers1[5].getName() , cus6);
        }
        return dataset;
    }
    public static void setTableHeaderColor(JTable table, int columnIndex, Color c) {
        TableColumn column = table.getTableHeader().getColumnModel().getColumn(columnIndex);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {

                setHorizontalAlignment(JLabel.CENTER);
                ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                        .setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        TableColumn column5 = table.getTableHeader().getColumnModel().getColumn(5);
        DefaultTableCellRenderer cellRenderer1 = new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column5) {

                setHorizontalAlignment(JLabel.CENTER);
                ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                        .setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column5);
            }
        };
        cellRenderer.setBackground(c);
        cellRenderer1.setBackground(c);
        cellRenderer1.setForeground(Color.white);
        column.setHeaderRenderer(cellRenderer);
        column5.setHeaderRenderer(cellRenderer1);
    }
}
