import de.vandermeer.asciitable.AsciiTable;
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
                    if (selectedColumn<6)
                        colorIndexPar[selectedRow][selectedColumn]=TextField1.getText(); }
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
        String choice_1;
        String name = "";
        String club = "";
        String handicap = "";
        int serial_number=0;
        System.out.println("=== Welcome to amateur Golf tournament system ===");
        loopChoice:
        for (int a=0;a<20;a++){
            String choice_temp = scanner.nextLine();
            System.out.printf("Are you customer or manager? C(customer) / M(manager): ");
            choice_1 = scanner.nextLine();
            if (choice_1.equals("C")){
                System.out.printf("Please enter your name: ");
                name = scanner.nextLine();
                System.out.printf("Please enter your club: ");
                club = scanner.nextLine();
                System.out.printf("Please enter your handicap: ");
                handicap = scanner.nextLine();
            }else if (choice_1.equals("M")){
                loopManager:
                for (int i=0;i<20;i++){
                    System.out.println("===================");
                    System.out.println("1. Enter customer scores");
                    System.out.println("2. View customer scores in console");
                    System.out.println("3. View customer profile in console");
                    System.out.println("4. Generate total results' bar chart for all customer");
                    System.out.println("5. Generate the score chart in detail");
                    System.out.println("6. Exit manager menu");
                    System.out.println("===================");
                    try {
                        System.out.printf("Please input serial number (e.g. 1,2) to obtain service: ");
                        serial_number = scanner.nextInt();
                        switch (serial_number){
                            case 1:
                                enterCustomerProfile(choice_1,name,club,handicap);
                                break;
                            case 2:
                                viewCustomerScores();
                                break;
                            case 3:
                                viewCustomerProfile();
                                break;
                            case 4:
                                GolfScoreSystem chart = new GolfScoreSystem("Bar Chart","Total Calculation bar Chart");
                                chart.pack();
                                chart.setVisible( true );
                                break;
                            case 5:
                                GolfScoreSystem chart1 = new GolfScoreSystem("Scores chart");
                                break;
                            case 6:
                                break loopManager;
                            default:
                                System.out.println("Please input correct number to continue!");
                                break;
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                        continue;
                    }
                }
            }else {
                System.out.println("Please enter capital 'C' or capital 'M' to continue!");
                continue;
            }
        }
        }

    public static void enterCustomerProfile(String choice_1,String name,String club,String handicap) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
            int[] scores = new int[18];
            int j;
            int sum=0;
        Customer[] customers1=new Customer[customers.size()];
        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }
        for (int i=0;i<18;i++){
                j=i+1;
                System.out.printf("Hole_"+j+" score: ");
                scores[i]=scanner.nextInt();
                sum+=scores[i];
            }
            customer.setHole_scores(scores);
            customer.setName(name);
            customer.setClub(club);
            customer.setHandicap(handicap);
            customer.setTotal_result(sum);
            customers.add(customer);
    }

    public static void viewCustomerScores(){
        Object[][] customerScores=new Object[18][];
        Customer[] customers1=new Customer[customers.size()];

        for (int i=0;i<customers.size();i++){
            customers1[i]=(Customer)customers.get(i);
        }

        for (int i=0;i<18;i++){
            for (int j=0;j<customers.size();j++){
                if (customers1.length==1)
                    customerScores[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2]
                            , colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5],customers1[0].getHole_scores()[i]};
                if (customers1.length==2)
                    customerScores[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2]
                            , colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5],customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i]};
                if (customers1.length==3)
                    customerScores[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2]
                            , colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5],customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i],customers1[2].getHole_scores()[i]};
                if (customers1.length==4)
                    customerScores[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2]
                            , colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5],customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i],customers1[2].getHole_scores()[i],customers1[3].getHole_scores()[i]};
                if (customers1.length==5)
                    customerScores[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2]
                            , colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5],customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i],customers1[2].getHole_scores()[i],customers1[3].getHole_scores()[i],customers1[4].getHole_scores()[i]};
                if (customers1.length==6)
                    customerScores[i]= new Object[]{colorIndexPar[i][0], colorIndexPar[i][1], colorIndexPar[i][2]
                            , colorIndexPar[i][3], colorIndexPar[i][4], colorIndexPar[i][5],customers1[0].getHole_scores()[i],customers1[1].getHole_scores()[i],customers1[2].getHole_scores()[i],customers1[3].getHole_scores()[i],customers1[4].getHole_scores()[i],customers1[5].getHole_scores()[i]};
            }
        }
        String[] columnNames = {"No.","BLUE","WHITE","RED","Index","PAR","A","B","C","D","E","F"};
        TextTable resultTable = new TextTable(columnNames,customerScores);
        resultTable.printTable();

        AsciiTable at = new AsciiTable();
        at.addRule();
        if (customers1.length==0){
            at.addRow("Customer:");
            at.addRule();
            at.addRow("Gross:");
            at.addRule();
            at.addRow("Handicap:");
            at.addRule();
            at.addRow("NetScore:");
        }
        if (customers1.length==1) {
            at.addRow("Customer:", "A");
            at.addRule();
            at.addRow("Gross:",customers1[0].getTotal_result());
            at.addRule();
            at.addRow("Handicap:",customers1[0].getHandicap());
            at.addRule();
            at.addRow("NetScore:",customers1[0].getTotal_result()-Integer.parseInt(customers1[0].getHandicap()));
        }
        if (customers1.length==2) {
            at.addRow("Customer:", "A", "B");
            at.addRule();
            at.addRow("Gross:",customers1[0].getTotal_result(),customers1[1].getTotal_result());
            at.addRule();
            at.addRow("Handicap:",customers1[0].getHandicap(),customers1[1].getHandicap());
            at.addRule();
            at.addRow("NetScore:",customers1[0].getTotal_result()-Integer.parseInt(customers1[0].getHandicap()),customers1[1].getTotal_result()-Integer.parseInt(customers1[1].getHandicap()));
        }
        if (customers1.length==3) {
            at.addRow("Customer:", "A", "B", "C");
            at.addRule();
            at.addRow("Gross:",customers1[0].getTotal_result(),customers1[1].getTotal_result(),customers1[2].getTotal_result());
            at.addRule();
            at.addRow("Handicap:",customers1[0].getHandicap(),customers1[1].getHandicap(),customers1[2].getHandicap());
            at.addRule();
            at.addRow("NetScore:",customers1[0].getTotal_result()-Integer.parseInt(customers1[0].getHandicap()),customers1[1].getTotal_result()-Integer.parseInt(customers1[1].getHandicap()),customers1[2].getTotal_result()-Integer.parseInt(customers1[2].getHandicap()));
        }
        if (customers1.length==4) {
            at.addRow("Customer:", "A", "B", "C", "D");
            at.addRule();
            at.addRow("Gross:",customers1[0].getTotal_result(),customers1[1].getTotal_result(),customers1[2].getTotal_result(),customers1[3].getTotal_result());
            at.addRule();
            at.addRow("Handicap:",customers1[0].getHandicap(),customers1[1].getHandicap(),customers1[2].getHandicap(),customers1[3].getHandicap());
            at.addRule();
            at.addRow("NetScore:",customers1[0].getTotal_result()-Integer.parseInt(customers1[0].getHandicap()),customers1[1].getTotal_result()-Integer.parseInt(customers1[1].getHandicap()),customers1[2].getTotal_result()-Integer.parseInt(customers1[3].getHandicap()),customers1[3].getTotal_result()-Integer.parseInt(customers1[3].getHandicap()));
        }
        if (customers1.length==5) {
            at.addRow("Customer:", "A", "B", "C", "D", "E");
            at.addRule();
            at.addRow("Gross:",customers1[0].getTotal_result(),customers1[1].getTotal_result(),customers1[2].getTotal_result(),customers1[3].getTotal_result(),customers1[3].getTotal_result(),customers1[4].getTotal_result());
            at.addRule();
            at.addRow("Handicap:",customers1[0].getHandicap(),customers1[1].getHandicap(),customers1[2].getHandicap(),customers1[3].getHandicap(),customers1[4].getHandicap());
            at.addRule();
            at.addRow("NetScore:",customers1[0].getTotal_result()-Integer.parseInt(customers1[0].getHandicap()),customers1[1].getTotal_result()-Integer.parseInt(customers1[1].getHandicap()),customers1[2].getTotal_result()-Integer.parseInt(customers1[3].getHandicap()),customers1[3].getTotal_result()-Integer.parseInt(customers1[3].getHandicap()),customers1[4].getTotal_result()-Integer.parseInt(customers1[4].getHandicap()));
        }
        if (customers1.length==6) {
            at.addRow("Customer:", "A", "B", "C", "D", "E", "F");
            at.addRule();
            at.addRow("Gross:",customers1[0].getTotal_result(),customers1[1].getTotal_result(),customers1[2].getTotal_result(),customers1[3].getTotal_result(),customers1[3].getTotal_result(),customers1[4].getTotal_result(),customers1[5].getTotal_result());
            at.addRule();
            at.addRow("Handicap:",customers1[0].getHandicap(),customers1[1].getHandicap(),customers1[2].getHandicap(),customers1[3].getHandicap(),customers1[4].getHandicap(),customers1[5].getHandicap());
            at.addRule();
            at.addRow("NetScore:",customers1[0].getTotal_result()-Integer.parseInt(customers1[0].getHandicap()),customers1[1].getTotal_result()-Integer.parseInt(customers1[1].getHandicap()),customers1[2].getTotal_result()-Integer.parseInt(customers1[3].getHandicap()),customers1[3].getTotal_result()-Integer.parseInt(customers1[3].getHandicap()),customers1[4].getTotal_result()-Integer.parseInt(customers1[4].getHandicap()),customers1[5].getTotal_result()-Integer.parseInt(customers1[5].getHandicap()));
        }
        at.addRule();
        String rend = at.render();
        System.out.println(rend);



        /*if (customers1.length==1)
            System.out.println("Total result of A:"+customers1[0].getTotal_result());
        if (customers1.length==2) {
            System.out.println("Total result of A:" + customers1[0].getTotal_result());
            System.out.println("Total result of B:" + customers1[1].getTotal_result());
        }
        if (customers1.length==3) {
            System.out.println("Total result of A:"+customers1[0].getTotal_result());
            System.out.println("Total result of B:"+customers1[1].getTotal_result());
            System.out.println("Total result of C:" + customers1[2].getTotal_result());
        }
        if (customers1.length==4) {
            System.out.println("Total result of A:"+customers1[0].getTotal_result());
            System.out.println("Total result of B:"+customers1[1].getTotal_result());
            System.out.println("Total result of C:" + customers1[2].getTotal_result());
            System.out.println("Total result of D:" + customers1[3].getTotal_result());
        }
        if (customers1.length==5) {
            System.out.println("Total result of A:"+customers1[0].getTotal_result());
            System.out.println("Total result of B:"+customers1[1].getTotal_result());
            System.out.println("Total result of C:" + customers1[2].getTotal_result());
            System.out.println("Total result of D:" + customers1[3].getTotal_result());
            System.out.println("Total result of E:" + customers1[4].getTotal_result());
        }
        if (customers1.length==6) {
            System.out.println("Total result of A:"+customers1[0].getTotal_result());
            System.out.println("Total result of B:"+customers1[1].getTotal_result());
            System.out.println("Total result of C:" + customers1[2].getTotal_result());
            System.out.println("Total result of D:" + customers1[3].getTotal_result());
            System.out.println("Total result of E:" + customers1[4].getTotal_result());
            System.out.println("Total result of F:" + customers1[5].getTotal_result());
        }*/
    }

    public static void viewCustomerProfile(){
        Customer[] customers1=new Customer[customers.size()];
        for (int i=0;i<customers.size();i++){
            int j=i+1;
            customers1[i]=(Customer)customers.get(i);
            System.out.println("NO.: "+j);
            System.out.println("Name: "+customers1[i].getName());
            System.out.println("Club: "+customers1[i].getClub());
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
