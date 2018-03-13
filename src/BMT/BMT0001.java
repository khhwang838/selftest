package BMT;
/*package bmt.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bmt.com.BmtInputDto;
import bmt.com.BmtOutputDto;
import bmt.com.PasswdMngt;


@Controller
public class BMT0001 {
	
	@Autowired
	private PasswdMngt  passwdMngt;
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/BMT0001/method01.do", method=RequestMethod.GET)
	@ResponseBody
	public BmtOutputDto method01(BmtInputDto in){
		
		logger.debug("Start Service");
		
		BmtOutputDto out = new BmtOutputDto();
		
		if ( passwdMngt.checkPasswd(in.getPwd()) ) {
			throw new RuntimeException("Error : check passwd");
		} 
		
		out.setDesc("Executed on  " + new Date());
		
		if ( in.getAmt() > 1000 ) {
			in.setMessage("고액입금 거래입니다.");
		} else if ( in.getAmt() < 0 ) { 
			throw new RuntimeException("마이너스 금액은 입금할 수 없습니다.");
		} else {
			in.setMessage("일반입금 거래입니다.");
		}
		
		out.setAmt(in.getAmt());
		
		if ( in.getMessage() == null || in.getMessage().isEmpty() ) {
			in.setMessage("This is a default message.");
		} else {
			// do nothing
		}
		
		out.setMessage(in.getMessage());
		
		switch(in.getCode()) {
			case 1 :
				in.setDesc(in.getMessage() + "Code 1");
				break;
			case 2 :
				in.setDesc(in.getMessage() + "Code 2");
				break;
			case 3 :
				in.setDesc(in.getMessage() + "Code 3");
				break;
			case 4 :
				in.setDesc(in.getMessage() + "Code 4");
				break;
			case 5 :
				in.setDesc(in.getMessage() + "Code 5");
				break;
			default:
				throw new RuntimeException("switch default");
		}
		
		out.setMessage(in.getMessage());
		
		return out;
	}

	@RequestMapping(value="/BMT0001/method02.do", method=RequestMethod.GET)
	@ResponseBody
	public BmtOutputDto method02(BmtInputDto in){
		
		logger.debug("Start Service");
		
		if ( passwdMngt.checkPasswd(in.getPwd()) ) {
			throw new RuntimeException("Error : check passwd");
		} 

		BmtOutputDto out = new BmtOutputDto();
		out.setMessage("method02 ");
		
		if(in.getMessage() == null || in.getMessage().isEmpty()){
			in.setMessage("This is default message.");
			if(in.getDesc() == null || in.getDesc().isEmpty()){
				in.setDesc("This is default desc.");
				if(in.getCode() == 1){
					out.setCode(in.getCode());
				}
				else if(in.getCode() == 2){
					out.setCode(in.getCode() * 2);
				}
				else{
					out.setCode(0);
				}
			}
			else{
				out.setDesc(in.getDesc());
			}
		}
		
		out.setDesc("Executed on  " + new Date());
		
		if(in.getDesc() != null && !in.getDesc().isEmpty()){
			out.setDesc(in.getDesc());
		}
		
		for(int i = 0; i < in.getCode() ; i++){
			out.setMessage(out.getMessage() + String.valueOf(i) + " ");
		}
		
		out.setAccoNo(in.getAccoNo());
		out.setAmt(in.getAmt());
		
		return out;
	}
	
	@RequestMapping(value="/BMT0001/method03.do", method=RequestMethod.GET)
	@ResponseBody
	public BmtOutputDto method03(BmtInputDto in){
		
		logger.debug("Start Service");
		
		if ( passwdMngt.checkPasswd(in.getPwd()) ) {
			throw new RuntimeException("Error : check passwd");
		} 
		
		BmtOutputDto out = new BmtOutputDto();

		switch(in.getCode()){
			case 1 :
				if(in.getMessage() == null || in.getMessage().isEmpty()){
					in.setMessage("Code 1 ");
					if(in.getDesc() == null || in.getDesc().isEmpty()){
						in.setDesc(in.getMessage() + " Desc 1");
					}
					else{
						out.setDesc("Executed on  " + new Date());
					}
				}
				out.setCode(in.getCode());
				break;
			case 2 :
				if(in.getMessage() == null || in.getMessage().isEmpty()){
					in.setMessage("Code 2");
				}
				out.setCode(in.getCode());
				break;
			case 3 :
				if(in.getMessage() == null || in.getMessage().isEmpty()){
					in.setMessage("Code 3 ");
					if(in.getDesc() == null || in.getDesc().isEmpty()){
						in.setDesc(in.getMessage() + " Desc 3 ");
					}
				}
				out.setCode(in.getCode());
				break;
			default:
				throw new RuntimeException("switch default");
		}
		
		out.setMessage(in.getMessage());
		out.setDesc(in.getDesc());
		
		return out;
	}
	
	@RequestMapping(value="/BMT0001/method04.do", method=RequestMethod.GET)
	@ResponseBody
	public BmtOutputDto method04(BmtInputDto in){
		
		logger.debug("Start Service");

		
		
		
		
		return new BmtOutputDto();
	}
	
	@RequestMapping(value="/BMT0001/method05.do", method=RequestMethod.GET)
	@ResponseBody
	public BmtOutputDto method05(BmtInputDto in){
		
		logger.debug("Start Service");

		
		
		
		return new BmtOutputDto();
	}
	
	
}
*/