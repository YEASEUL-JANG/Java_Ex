package ch17;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardEx extends JFrame{
	CardLayout card;
	Container con= getContentPane();//컨텐츠팬을 알아낸다.(컨텐츠팬은 Container타입)
	public CardEx() {
		super("CardLayout 예제");
		card = new CardLayout();
		setLayout(card);//기본 레이아웃을 카드레이아웃으로 변경
		JPanel[] pan = new JPanel[5];//패널을 배열처리
		Color[] color = {Color.red, Color.yellow, Color.green,Color.blue,Color.cyan};
		
		for(int i=0;i<pan.length;i++) {
			pan[i]=new JPanel();//패널을 생성
			pan[i].setBackground(color[i]);//패널 배경색 설정
			add("카드",pan[i]);//add("이름",컴퍼넌트) : "카드"라는 이름으로 카드에 패널들을 차례로 추가

			//패널에 마우스 이벤트를 추가
			pan[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					card.next(con);//다음화면으로 이동됨
					//card.previous(con); 이전화면으로 이동
				}
			});
			setSize(300,300);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}//end for
	}//기본생성자
	public static void main(String[] args) {
		new CardEx();
	}
}
