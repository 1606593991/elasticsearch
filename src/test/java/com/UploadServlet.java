package com;

import com.wyb.util.StreamHelper;
import com.wyb.util.StringHelper;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
@RequestMapping("/api")
public class UploadServlet {
	private Logger logger = LoggerFactory.getLogger(UploadServlet.class);
	@RequestMapping(value="/up", method = RequestMethod.POST)
	public @ResponseBody String uploadDisk(HttpServletRequest request,MultipartHttpServletRequest multiReq) {
		String savefolder="a";
		String jsonResult = "0";
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
//				.getFile("myfile");
		
		
		MultipartFile file =multiReq.getFile("myfile");
		logger.info("begin save:"+savefolder+"  "+file.getName());
		String filename = file.getName();
//		String savefolder = request.getParameter("savefolder");
//		String filename = request.getParameter("filename");
		FileOutputStream out = null;
		// long size = file.getSize();

		try {

			if (file.isEmpty()) {
				return "401";
			} else if (StringHelper.isEmpty(savefolder)) {
				return "402";
			} else if (StringHelper.isEmpty(filename)) {
				return "403";
			}
			String rootDir = gayzw_disk_savepath;
			String saveDir = rootDir + File.separator + savefolder;
			if (!StreamHelper.hasDir(saveDir)) {
				StreamHelper.createDir(saveDir);
			}
			String savePath = saveDir + File.separator + filename;
			File uploadFile = new File(savePath);
			FileCopyUtils.copy(file.getBytes(), uploadFile);
			jsonResult = "200";
			logger.info("finish save:"+savePath);
			
			String saveFinishDir =rootDir + File.separator + savefolder+"_finish";
			if (!StreamHelper.hasDir(saveFinishDir)) {
				StreamHelper.createDir(saveFinishDir);
			}
			String saveFinishPath = saveFinishDir + File.separator + filename;
			
			File uploadCopyFile = new File(saveFinishPath);
			FileCopyUtils.copy(uploadFile, uploadCopyFile);
			
			logger.info("finish save:"+saveFinishPath);
			
			StreamHelper.deletFile(uploadFile);
			
			logger.info("delete file:"+savePath);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonResult = "500";
		} finally {
			StreamHelper.close(out);
		}
		
		return jsonResult;
	}
	
	
	/**接收的数据包保存目录**/
	@Value("${gayzw.disk.savepath}")
	protected String gayzw_disk_savepath;
}

