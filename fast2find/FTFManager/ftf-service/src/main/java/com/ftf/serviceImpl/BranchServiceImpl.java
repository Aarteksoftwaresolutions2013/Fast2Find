package com.ftf.serviceImpl;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ftf.model.Branch;
import com.ftf.repository.BranchRepository;
import com.ftf.service.BranchService;
import com.ftf.util.Encryption;
import com.ftf.util.IConstant;
/**
 * @author PravinSir
 *
 */
@Service
public class BranchServiceImpl implements BranchService {
  private static final Logger logger = Logger.getLogger(BranchServiceImpl.class);
  private static final String GEOCODE_REQUEST_URL = "http://maps.googleapis.com/maps/api/geocode/xml?sensor=false&";
  private static HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
  @Autowired
  private BranchRepository branchRepository;
  
  /**
   * businessEventInfoAdd() use for save business information into database.
   * In this method use geocode to get latitude and longitude using address.
   */
  public boolean businessEventInfoAdd(Branch branch) {
    boolean status = false;
    if (branch != null) {
      String address = branch.getLocation().getAddress() + "," + branch.getLocation().getCityName()
          + "," + branch.getLocation().getStateName() + "," + branch.getLocation().getZipCode();
      branch.setIsDeleted(IConstant.IS_DELETED);
      try {
        StringBuilder urlBuilder = new StringBuilder(GEOCODE_REQUEST_URL);
        if (StringUtils.isNotBlank(address)) {
          urlBuilder.append("&address=").append(URLEncoder.encode(address, "UTF-8"));
        }
        final GetMethod getMethod = new GetMethod(urlBuilder.toString());
        try {
          httpClient.executeMethod(getMethod);
          Reader reader = new InputStreamReader(getMethod.getResponseBodyAsStream(),
              getMethod.getResponseCharSet());

          int data = reader.read();
          char[] buffer = new char[1024];
          Writer writer = new StringWriter();
          while ((data = reader.read(buffer)) != -1) {
            writer.write(buffer, 0, data);
          }
          String result = writer.toString();
          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder db = dbf.newDocumentBuilder();
          InputSource is = new InputSource();
          is.setCharacterStream(new StringReader("<" + writer.toString().trim()));
          Document doc = db.parse(is);
          String strLatitude = getXpathValue(doc,
              "//GeocodeResponse/result/geometry/location/lat/text()");
          String strLongtitude = getXpathValue(doc,
              "//GeocodeResponse/result/geometry/location/lng/text()");
          branch.setLatitude(strLatitude);
          branch.setLongitude(strLongtitude);
          StringBuffer sb = new StringBuffer(branch.getLocation().getCityName());
          sb.append(",");
          sb.append(branch.getLocation().getAddress());
          sb.append(",");
          sb.append(branch.getLocation().getZipCode());
          String s = sb.toString();
          branch.setSearchData(s);
          if (branch.getEventName() != null) {
            branch.setBranchType(IConstant.EVENT);
          }
          branch.getLogin().setUserType(IConstant.TALLY_USER);
          branch.getLogin().setPaidStatus(IConstant.PAID_USER_YES);
          branch.getLogin().setPassword(Encryption.encrypt(branch.getLogin().getPassword()));
          status = branchRepository.businessEventInfoAdd(branch);

        } finally {
          getMethod.releaseConnection();
        }
      } catch (Exception e) {
        e.printStackTrace();
        logger.error("Inside a businessEventInfoAdd of BranchServiceImpl:-", e);
      }
    }
    if (status) {
      return true;
    } else {
      return false;
    }
  }

  private String getXpathValue(Document doc, String strXpath) throws XPathExpressionException {
    XPath xPath = XPathFactory.newInstance().newXPath();
    XPathExpression expr = xPath.compile(strXpath);
    String resultData = null;
    Object result4 = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList nodes = (NodeList) result4;
    for (int i = 0; i < nodes.getLength(); i++) {
      resultData = nodes.item(i).getNodeValue();
    }
    return resultData;
  }
  
  /**
   * getbusiness() use to get business information from database.
   * @param businessAndEventId
   */
  public List<Branch> getbusiness(Integer businessAndEventId) {
    return branchRepository.getbusiness(businessAndEventId);
  }
  /**
   * getBusinessInfoById() use to get business information from database.
   * decrypt() use to decrypt password.
   * @param branchId
   */
  public Branch getBusinessInfoById(Integer branchId) {
    List<Object> list = new ArrayList<Object>();
    Branch branch = new Branch();
    list = branchRepository.getBusinessInfoById(branchId);
    for (Object object : list) {
      branch = (Branch) object;
      branch.getLogin().setPassword(Encryption.decrypt(branch.getLogin().getPassword()));
    }
    return branch;
  }
  
  /**
   * getEventName method use for get event name from database.
   * @param businessAndEventId
   */
  public List<Branch> getEventName(Integer businessAndEventId) {
    return branchRepository.getEventName(businessAndEventId);
  }
  /**
   * getSubCategoryName() get sub category name using corresponding to category id
   * @param categoryId
   */
  public List<Object> getSubCategoryName(Integer categoryId) {
    List<Object> subCategoryList = new ArrayList<Object>();
    subCategoryList = branchRepository.getSubCategoryName(categoryId);
    return subCategoryList;
  }
  /**
   * getCategoryName() use to get category name.
   * @param categoryId
   */
  public List<Object> getCategoryName(Integer categoryId) {
    List<Object> categoryList = new ArrayList<Object>();
    categoryList = branchRepository.getCategoryName(categoryId);
    return categoryList;
  }
  /**
   * addEventInformation() use to save event information into database..
   * In this method also use geocode for get letitude and longitude. 
   */
  public boolean addEventInformation(Branch branch) {
      boolean status = false;
      if (branch != null) {
        String address = branch.getLocation().getAddress() + "," + branch.getLocation().getCityName()
            + "," + branch.getLocation().getStateName() + "," + branch.getLocation().getZipCode();
        branch.setIsDeleted(IConstant.IS_DELETED);
        try {
          StringBuilder urlBuilder = new StringBuilder(GEOCODE_REQUEST_URL);
          if (StringUtils.isNotBlank(address)) {
            urlBuilder.append("&address=").append(URLEncoder.encode(address, "UTF-8"));
          }
          final GetMethod getMethod = new GetMethod(urlBuilder.toString());
          try {
            httpClient.executeMethod(getMethod);
            Reader reader = new InputStreamReader(getMethod.getResponseBodyAsStream(),
                getMethod.getResponseCharSet());

            int data = reader.read();
            char[] buffer = new char[1024];
            Writer writer = new StringWriter();
            while ((data = reader.read(buffer)) != -1) {
              writer.write(buffer, 0, data);
            }
            String result = writer.toString();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader("<" + writer.toString().trim()));
            Document doc = db.parse(is);

            String strLatitude = getXpathValue(doc,
                "//GeocodeResponse/result/geometry/location/lat/text()");
            String strLongtitude = getXpathValue(doc,
                "//GeocodeResponse/result/geometry/location/lng/text()");
            branch.setLatitude(strLatitude);
            branch.setLongitude(strLongtitude);
            StringBuffer sb = new StringBuffer(branch.getLocation().getCityName());
            sb.append(",");
            sb.append(branch.getLocation().getAddress());
            sb.append(",");
            sb.append(branch.getLocation().getZipCode());
            String s = sb.toString();
            branch.setSearchData(s);
            if (branch.getEventName() != null) {
              branch.setBranchType(IConstant.EVENT);
            }
            branch.getLogin().setUserType(IConstant.TALLY_USER);
            branch.getLogin().setPaidStatus(IConstant.PAID_USER_YES);
            branch.getLogin().setPassword(Encryption.encrypt(branch.getLogin().getPassword()));
            status = branchRepository.addEventInformation(branch);

          } finally {
            getMethod.releaseConnection();
          }
        } catch (Exception e) {
          e.printStackTrace();
          logger.error("Inside a addEventInformation of BranchServiceImpl:-", e);
        }
      }
      if (status) {
        return true;
      } else {
        return false;
      }
  }
}
