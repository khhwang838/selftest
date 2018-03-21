package watch_service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class MyWatchService {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		String configFilePath = "D:\\chatbot\\aibot\\conf\\commons.properties";
		int lastIndexOfSeparator = configFilePath.lastIndexOf(File.separator);
		String configDirPath = configFilePath.substring(0, lastIndexOfSeparator);
		System.out.println(configDirPath);
		
		Path path = Paths.get(configDirPath);
		WatchService watchService = path.getFileSystem().newWatchService();
		path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		boolean startModifyFile = true;
		for(;;) {
			WatchKey key = watchService.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println(event.count() + event.kind().name());
				// 파일명 출력
				System.out.println(event.context().toString());
				
				if ( StandardWatchEventKinds.ENTRY_MODIFY.equals(event.kind()) && startModifyFile) {
					startModifyFile = false;
					continue;
				}
				if ( event.count()== 1 && StandardWatchEventKinds.ENTRY_MODIFY.equals(event.kind()) ) {
					// 설정값 다시 읽어오기
					System.out.println("Reloading config values....");
					startModifyFile = true;
				} else {
					System.out.println("Not modification event.");
				}
			}
			
			boolean isValid = key.reset();
			if (!isValid) {
				// file no longer regiestered
				System.out.println("Config file does not exist...");
			}
			System.out.println("================================");
			Thread.sleep(5000);
		}
	}

	
}
