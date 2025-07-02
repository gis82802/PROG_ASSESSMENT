import java.util.Scanner;

public class J_1018_02 {
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		System.out.print("(use EOF can end the function.):");
		while(sn.hasNext()){
			String in = sn.next(); //path[i].
			//System.out.println(in.length());
			int coordX[] = new int[in.length() + 1];
			int coordY[] = new int[in.length() + 1];
			coordX[0] = 0;
			coordY[0] = 0;
			
			for(int i=1;i<=in.length();i++){
				//System.out.println(in.charAt(i-1));
				int a = in.charAt(i-1);
				if(a==78 || a==110){ //Nn
					coordX[i] = coordX[i-1];
					coordY[i] = coordY[i-1] + 1;
				}else if(a==83 || a==115){ //Ss
					coordX[i] = coordX[i-1];
					coordY[i] = coordY[i-1] - 1;
				}else if(a==69 || a==101){ //Ee
					coordX[i] = coordX[i-1] + 1;
					coordY[i] = coordY[i-1];
				}else if(a==87 || a==119){ //Ww
					coordX[i] = coordX[i-1] - 1;
					coordY[i] = coordY[i-1];
				}
				//System.out.printf("coord(%d,%d)\n",coordX[i],coordY[i]);
			}
			
			int x = 0;
			for(int i=0;i<=in.length();i++){
				for(int j=i+1;j<=in.length();j++){
					if(coordX[i]==coordX[j] && coordY[i]==coordY[j]){
						x = 1;
						break;
					}
				}
				if(x == 1)break;
			}
			
			System.out.print("input: path=\"" +in +"\", output: ");
			if(x == 1)System.out.println("true");
			else      System.out.println("flase");
			System.out.print(":");
		}
		sn.close();
	}
}
