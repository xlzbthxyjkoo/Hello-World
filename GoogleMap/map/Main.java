package map;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Main extends JFrame {
	
	private JTextField textField = new JTextField(30); //검색창
	private JButton button = new JButton("search"); //검색버튼	
	private GoogleAPI googleAPI = new GoogleAPI();  	
	private JLabel googleMap = new JLabel(); //구글맵이 올라오는 라벨
	private JPanel panel = new JPanel(); //패널
	
	
	public Main() {
		setTitle("gOogLEmAp"); 
		setLayout(new BorderLayout()); //JFrame을 borderlayout으로 설정
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료할때 프로그램이 완전히 종료될 수 있게 한다.
	    setResizable(false); //응용프로그램 창의 사이즈 조절을 못하게 한다.
	    setVisible(true); //시각화
	    
	    panel.add(textField); //패널에 텍스트 필드 추가
	    panel.add(button); //패널에 버튼 추가
	    
	    button.addMouseListener(new Event());
	    add(BorderLayout.NORTH, panel); //borderlayout은 위치를 동서남북으로 정할수 있다
	    
	    pack();  //여기서 pack()은 프레임내에 서브컴포넌트들의 레이아웃과 Prefered Size에 맞도록 윈도우의 사이즈를 맞추는 작업이다.
	}
	
	public class Event implements MouseListener {//함수가 실행될 수 있는 조건을 만들어준다.
	      @Override
	      public void mouseClicked(MouseEvent e) {
	         setMap(textField.getText());  //검색한것 가져오기
	      }

	      @Override
	      public void mouseEntered(MouseEvent e) {
	         // TODO Auto-generated method stub
	         
	      }

	      @Override
	      public void mouseExited(MouseEvent e) {
	         // TODO Auto-generated method stub
	         
	      }

	      @Override
	      public void mousePressed(MouseEvent e) {
	         // TODO Auto-generated method stub
	         
	      }

	      @Override
	      public void mouseReleased(MouseEvent arg0) {
	         // TODO Auto-generated method stub
	         
	      }
	}
	
	public void setMap(String location) { //마우스를 눌렀을 때 입력에 따라서 맵을 바꿔주는것.
		googleAPI.downloadMap(location); //주소를 검색한 뒤 검색내역을 이미지로 받아옴
		googleMap.setIcon(googleAPI.getMap(location)); //Label의 다운받은 이미지를 바꿔준다.
		googleAPI.fileDelete(location); //파일을 프로젝트 내에서 삭제한다.
		add(BorderLayout.SOUTH, googleMap); //구글맵을 아래에 위치
		
		pack(); //여기서 pack()은 프레임내에 서브컴포넌트들의 레이아웃과 Prefered Size에 맞도록 윈도우의 사이즈를 맞추는 작업이다
	}
}
