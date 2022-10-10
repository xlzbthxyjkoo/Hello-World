package map;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class GoogleAPI {
	
	public void downloadMap(String location) { //지도API 지도 이미지 자체를 받아오는 함수를 만든다.
		
		try {
			String imageURL = "https://maps.googleapis.com/maps/api/staticmap?key=발급 받은 키 입력" + URLEncoder.encode(location, "UTF-8") + "&zoom=16&size=612x612&scale=2";
			URL url = new URL(imageURL);
			
			InputStream is = url.openStream();  //해당 주소에 접근할 수 있게 해준다.
			OutputStream os = new FileOutputStream(location);  //실제로 해당 주소에 접근하여 다운로드 받을 수 있도록 한다,.
			
			byte[] b = new byte[2048]; //바이트 배열 할당.
			
			int length;  //길이 -> 어디까지 다운 받을지 알려주는 변수
			
			while((length = is.read(b)) != -1) {  //파일을 계쏙 읽어온다. 파일을 쓸데가 없을때까지
				os.write(b, 0, length);  //파일을 사용자가 원하는 주소에 맵을 실제 이미지 파일로 다운 받는것 / 프로젝트가 실행되는 폴더에 이미지가 다운
			}
			is.close(); os.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();  //오류가 나면 오류가 발생했다고 알려주는 구분.
		}
	}
	
	public ImageIcon getMap(String location) {//다운로드 받은 이미지 파일을 가지고 올 수 있도록한다.
		/*로딩한 이미지를 getScaledInstance() 함수를 통해서 다음과 같이 크기 변환을 하면 변환된 이미지의 품질이 떨어지지 않게 되었다. */
		return new ImageIcon((new ImageIcon(location)).getImage().getScaledInstance(612, 612, java.awt.Image.SCALE_SMOOTH));//getScaledInstance
	}
	
	public void fileDelete(String fileName) {  //얻어온 파일을 삭제하는 함수
		File f = new File(fileName); //특정 파일을 삭제하는 함수
		f.delete();
		
	}
}
