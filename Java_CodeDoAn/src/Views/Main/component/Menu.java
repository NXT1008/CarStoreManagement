package Views.Main.component;

import Views.Main.Model.Menu_Model;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Menu extends javax.swing.JPanel {

    public void addEventMenu(EventMenu event) {
        this.event = event;
    }

    private int selectedIndex = -1;
    private final Timer timer;
    private boolean toUp;   //  For animation is go up
    private int menuYTarget;
    private int menuY;
    private int speed = 2;
    private EventMenuCallBack callBack;
    private EventMenu event;

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu.setOpaque(false);
        listMenu.addEventSelectedMenu(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if (index != selectedIndex) {
                    Menu.this.callBack = callBack;
                    toUp = selectedIndex > index;
                    if (selectedIndex == -1) {
                        speed = 20; // Start Speed
                    } else {
                        speed = selectedIndex - index;
                        if (speed < 0) {
                            speed *= -1;
                            //  If speed valus <0 change it to <0   Ex : -1 to 1
                        }
                    }
                    //speed++;    //  Add 1 speed
                    // Tăng tốc độ lên 5 lần
                    speed += 3;
                    selectedIndex = index;
                    menuYTarget = selectedIndex * 35 + listMenu.getY(); //  menuYTarget is location y
                    if (!timer.isRunning()) {
                        timer.start();
                    }
                }
            }
        });
//        timer = new Timer(0, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                if (toUp) {
//                    if (menuY <= menuYTarget - 5) {
//                        menuY = menuYTarget;
//                        repaint();
//                        timer.stop();
//                        callBack.call(selectedIndex);
//                        if (event != null) {
//                            event.menuIndexChange(selectedIndex);
//                        }
//                    } else {
//                        menuY -= speed;
//                        repaint();
//                    }
//                } else {
//                    if (menuY >= menuYTarget + 5) { //  Add style
//                        menuY = menuYTarget;
//                        repaint();
//                        timer.stop();
//                        callBack.call(selectedIndex);
//                        if (event != null) {
//                            event.menuIndexChange(selectedIndex);
//                        }
//                    } else {
//                        menuY += speed;
//                        repaint();
//                    }
//                }
//            }
//        });

        timer = new Timer(10, new ActionListener() { // Đặt khoảng thời gian chờ là 10 miligiây
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (toUp) {
                    if (menuY <= menuYTarget - 5) {
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        menuY -= speed;
                        repaint();
                    }
                } else {
                    if (menuY >= menuYTarget + 5) {
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        // Điều chỉnh vị trí cuối cùng mượt mà hơn
                        if (Math.abs(menuY - menuYTarget) < 5) {
                            menuY = menuYTarget;
                            repaint();
                            timer.stop();
                            callBack.call(selectedIndex);
                            if (event != null) {
                                event.menuIndexChange(selectedIndex);
                            }
                        } else {
                            menuY += speed;
                            repaint();
                        }
                    }
                }
            }
        });


        init();
    }

    private void init() {
        listMenu.addItem(new Menu_Model("home", "Trang Chủ", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("employee", "Quản Lý Nhân Viên", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("car", "Quản Lý Ô Tô", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("customer", "Khách Hàng", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("agency", "Chi Nhánh", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("supplier", "Nhà Cung Cấp", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("invoice", "Hóa Đơn", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("receipt", "Phiếu Nhập", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("warehouse", "Kho", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("maintaince", "Dịch Vụ Bảo Dưỡng", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("maintaince_bill", "Phiếu Bảo Dưỡng", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("revenue", "Doanh Số", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("analyze", "Thống Kê", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("chart", "Lập Biểu Đồ", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("logout", "Đăng Xuất", Menu_Model.MenuType.MENU));
        listMenu.addItem(new Menu_Model("", "", Menu_Model.MenuType.EMPTY));
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // chống nhòe
        
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2.fill(area);
        
        if (selectedIndex >= 0) {
            int menuX = 10; // tọa độ x  của khung chữ nhật
            int height = 35; // chiều cao của khung chữ nhật = Chiều cao của Menu Item
            int width = getWidth(); // chiều rộng của khung chữ nhật
            g2.setColor(new Color(242, 242, 242)); // đặt màu vẽ cho khung chữ nhật
            g2.fillRoundRect(menuX, menuY, width, height, 35, 35);
            Path2D.Float f = new Path2D.Float();
            f.moveTo(width - 30, menuY);
            f.curveTo(width - 10, menuY, width, menuY, width, menuY - 30);
            f.lineTo(width, menuY + height + 30);
            f.curveTo(width, menuY + height, width - 10, menuY + height, width - 30, menuY + height);
                
            g2.fill(f);
        }
        super.paintComponent(grphcs);
    }



    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX() + 6;
                y = me.getY() + 6;
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }
    
    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        pictureBox1 = new Views.OtherForm.swing.PictureBox();
        listMenu = new Views.Main.component.ListMenu<>();

        panelMoving.setOpaque(false);

        lbLogo.setBackground(new java.awt.Color(255, 255, 255));
        lbLogo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbLogo.setForeground(new java.awt.Color(255, 255, 255));
        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbLogo.setText("Car Store");
        lbLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/Main/icon/logo.png"))); // NOI18N

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMovingLayout.createSequentialGroup()
                    .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 106, Short.MAX_VALUE)))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
        );

        listMenu.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(listMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbLogo;
    private Views.Main.component.ListMenu<String> listMenu;
    private javax.swing.JPanel panelMoving;
    private Views.OtherForm.swing.PictureBox pictureBox1;
    // End of variables declaration//GEN-END:variables
}
