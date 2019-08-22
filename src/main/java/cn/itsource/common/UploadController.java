/**
 * 代号:隐无为
 * 文件名：UploadController.java
 * 修改人：
 * 描述：
 */
package cn.itsource.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.util.StringUtil;

/**
 * 用途：上传图片
 */
@Controller
@RequestMapping("/upload")
@SuppressWarnings("all")
public class UploadController  {

	/**
	 * 功能: 上传文件(单个)  可上传 图片 、excel...等等
	 * 代号:隐无为
	 * @param request
	 * @param file:图片
	 * @param path:存放的路径
	 * @return
	 */
	@RequestMapping("/uploadFile")
	@ResponseBody
	public Map<String, String> uploadFile(HttpServletRequest request, MultipartFile file, String path) {
		Map<String, String>map = this.getUploadPath(request, file, path);   
		return map;
	}



	/*
	 * 上传文件(批量) 可上传 图片 、excel...等等
	 */
	@RequestMapping(value = "/uploadFiles")
	@ResponseBody
	public Map<String, Object> uploadFiles(HttpServletRequest request, MultipartFile[] file, String path) {
		Map<String, Object>map=new HashMap<>();
		if(StringUtil.isEmpty(path)){ 
			path="other/img";
		}
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < file.length; i++) {
			//uniqueName += file[i].getOriginalFilename() + ",";// 得到文件名
			Map<String, String> img = this.getUploadPath(request, file[i], path);
			if("200".equals(img.get("code"))){
				list.add(img.get("data"));
			}
		}
		if(list.size()!=file.length){
			map.put("code", 505);// 批量上传错误错误码
			map.put("msg", "批量上传错误--丢失照片--请重新上传丢失照片");
		}else{
			map.put("data", list);
			map.put("code", 200);// 
			map.put("msg", "批量上传成功");
		}
		return map;
	}

	/**
	 * @功能: 获取上传文件的路径
	 * @代号:隐无为
	 * @param request
	 * @param file
	 * @param path
	 * @return
	 */
	public Map<String, String> getUploadPath(HttpServletRequest request, MultipartFile file, String path) {
		Map<String, String>map=new HashMap<>();
		if(StringUtil.isEmpty(path)){ 
			path="other/img";
		}
		String basePath = request.getSession().getServletContext().getRealPath(path);
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		// 日期格式文件夹
		String datePath = sdf.format(new Date());
		// uuid随机名
		String uuidPath = UUID.randomUUID().toString();
		// 文件的后缀名
		String fileExit = getFileExit(file.getOriginalFilename());
		// 创建目录
		File dir = new File(basePath + datePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 创建文件的路径
		String newFilePath = basePath + datePath + uuidPath + fileExit;
		// 数据库存储的文件相对项目的路径
		String returnName = path + datePath + uuidPath + fileExit;
		File targetFile = new File(newFilePath);
		try {
			// 转存文件
			file.transferTo(targetFile);
			map.put("code", "200");
			map.put("msg", "success");
			map.put("data", returnName);
	
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "error-upload");
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 删除文件
	 * 
	 * @param imagepath
	 */
	public void deleteFile(String imagepath) {
		if (imagepath != null) {
			File image = new File(imagepath);
			if (image.exists()) {
				image.delete();
			}
		}
	}

	/**
	 * 取后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public String getFileExit(String fileName) {
		int index = fileName.lastIndexOf('.');
		return fileName.substring(index);
	}

}
