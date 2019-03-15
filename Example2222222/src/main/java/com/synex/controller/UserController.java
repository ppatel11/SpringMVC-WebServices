package com.synex.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping("/")
	public ModelAndView display() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("message", "Hello Everyone");
		return model;

	}

	@RequestMapping("/Admin")
	public ModelAndView displayAdmin() {
		ModelAndView model = new ModelAndView("Admin");
		return model;
	}

	@RequestMapping("/SearchUser")
	public ModelAndView dispalyAdmin() {
		ModelAndView model = new ModelAndView("SearchUser");

		return model;
	}

	@RequestMapping("/userDetails")
	public ModelAndView userDetails(@RequestParam("loginName") String loginName) {
		ModelAndView model = new ModelAndView("userDetails");
		model.addObject("loginName", loginName);
		return model;
	}

	@RequestMapping("/deal")
	public ModelAndView deal() {
		ModelAndView model = new ModelAndView("deal");
		return model;
	}
	
	@RequestMapping( value= "/uploadFile", method= RequestMethod.POST )
	public ModelAndView uploadFile(@RequestParam("excel") MultipartFile file) {
		ModelAndView model = new ModelAndView("deal");
		
		String fileName = file.getOriginalFilename();
		BufferedOutputStream stream = null;
		Workbook workbook = null;
		File serverFile  = null;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				File dir = new File("C:" + File.separator + "uploadExcelFile");
				// Creating the directory to store file
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
				stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				
				
				FileInputStream excelFile = new FileInputStream(serverFile);
				workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            
	            model.addObject("investmentName", datatypeSheet.getRow(3).getCell(CellReference.convertColStringToIndex("D")).getStringCellValue());
	            model.addObject("legalCloseDate", datatypeSheet.getRow(4).getCell(CellReference.convertColStringToIndex("D")).getDateCellValue());
	            model.addObject("taxId", datatypeSheet.getRow(5).getCell(CellReference.convertColStringToIndex("D")).getStringCellValue());
	            model.addObject("relationshipClient", datatypeSheet.getRow(6).getCell(CellReference.convertColStringToIndex("D")).getStringCellValue());
	            model.addObject("commitmentAmount", datatypeSheet.getRow(7).getCell(CellReference.convertColStringToIndex("D")).getNumericCellValue());
	            model.addObject("portfolioType", datatypeSheet.getRow(8).getCell(CellReference.convertColStringToIndex("D")).getStringCellValue());
	            model.addObject("syndicator", datatypeSheet.getRow(9).getCell(CellReference.convertColStringToIndex("D")).getStringCellValue());
	            
			 
	            model.addObject("investerOneName", datatypeSheet.getRow(3).getCell(CellReference.convertColStringToIndex("H")).getStringCellValue());
	            model.addObject("investerOneOwnerShip", datatypeSheet.getRow(3).getCell(CellReference.convertColStringToIndex("J")).getNumericCellValue());
	            model.addObject("investerOneBla1", datatypeSheet.getRow(3).getCell(CellReference.convertColStringToIndex("L")).getStringCellValue());
	            
	            model.addObject("investerTwoName", datatypeSheet.getRow(4).getCell(CellReference.convertColStringToIndex("H")).getStringCellValue());
	            model.addObject("investerTwoOwnerShip", datatypeSheet.getRow(4).getCell(CellReference.convertColStringToIndex("J")).getNumericCellValue());
	            model.addObject("investerTwoBla1", datatypeSheet.getRow(4).getCell(CellReference.convertColStringToIndex("L")).getStringCellValue());
	            
	            model.addObject("investerThreeName", datatypeSheet.getRow(5).getCell(CellReference.convertColStringToIndex("H")).getStringCellValue());
	            model.addObject("investerThreeOwnerShip", datatypeSheet.getRow(5).getCell(CellReference.convertColStringToIndex("J")).getNumericCellValue());
	            model.addObject("investerThreeBla1", datatypeSheet.getRow(5).getCell(CellReference.convertColStringToIndex("L")).getStringCellValue());
			
			} catch (Exception e) {
				System.out.println("You failed to upload " + fileName + " => " + e.getMessage());
			}finally {
				try {
					
					serverFile.delete();
					stream.close();
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("You failed to upload " + fileName + " because the file was empty.");
		}
		
		
		return model;
	}

}