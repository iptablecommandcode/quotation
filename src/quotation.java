package src;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class quotation {
    public static void main(String[] args) {
        //파일 위치 가져오기
        String jarDir = System.getProperty("user.dir");
        String filePath = jarDir + File.separator + "changeText.txt";

        //changeText 파일 읽기
        StringBuffer result = new StringBuffer();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //파일에서 한 줄씩 읽어오기
            while ((line = reader.readLine()) != null) {
                // 각 줄의 앞뒤 공백 제거 후 작은 따옴표 추가하여 결과에 추가
                if (!line.trim().isEmpty()) {
                    result.append("'").append(line.trim()).append("',\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //마지막 ,\n 제거
        result.delete(result.length() - 2, result.length());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}