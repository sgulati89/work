package com.spark.data.ingester;

/*import com.elsevier.spark_xml_utils.xpath.XPathException;
import com.elsevier.spark_xml_utils.xpath.XPathProcessor;

public class Validator {
	public static void main(String[] args) throws XPathException {
		XPathProcessor proc = XPathProcessor.getInstance("/ASSETS/ASSET");
		proc.evaluateString("<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE ASSETS SYSTEM \"assets.dtd\"><ASSETS ASOF_DATE=\"12/24/2014\" CREATE_DATE=\"12/24/2014\" RECORDS=\"22\"><ASSET><FhlmcModel_BND_CORP><ACCRUAL_DT>11/1/2011</ACCRUAL_DT><AMT_ISU>9999999999999999999999999</AMT_ISU><ANNOUNCE_DT>10/27/2011</ANNOUNCE_DT><CALC_TYPE>1</CALC_TYPE><CD_INSTMT_TYPE>UNKNOWN</CD_INSTMT_TYPE><CE_set SIZE=\"1\"><CE_record><CONDITIONAL>D</CONDITIONAL><MATURITY>11/1/2016</MATURITY><PCT>100</PCT><PROVIDER>000375</PROVIDER><START_DATE>11/1/2011</START_DATE><TYPE>G</TYPE></CE_record></CE_set><CHANGE_DT>11/15/2013 22:58:06.183</CHANGE_DT><COMPOUND_FLAG>0</COMPOUND_FLAG><COUNTRY>GB</COUNTRY><COUPON_FIX>2.248</COUPON_FIX><COUP_FREQ>S</COUP_FREQ><CPN_TYPE>F</CPN_TYPE><CURRENCY>USD</CURRENCY><CUSIP>05565QBT4</CUSIP><CUSIP2_set SIZE=\"3\"><CUSIP2_record><CODE>B</CODE><IDENTIFIER>EI8592145</IDENTIFIER></CUSIP2_record><CUSIP2_record><CODE>C</CODE><IDENTIFIER>B706L81</IDENTIFIER></CUSIP2_record><CUSIP2_record><CODE>I</CODE><IDENTIFIER>US05565QBT40</IDENTIFIER></CUSIP2_record></CUSIP2_set><CUSIP_ALIAS_set SIZE=\"3\"><CUSIP_ALIAS_record><CODE>51371</CODE><IDENTIFIER>40703</IDENTIFIER><PURPOSE>DAWM</PURPOSE></CUSIP_ALIAS_record><CUSIP_ALIAS_record><CODE>51371</CODE><IDENTIFIER>71521</IDENTIFIER><PURPOSE>DAWM</PURPOSE></CUSIP_ALIAS_record><CUSIP_ALIAS_record><CODE>8001</CODE><IDENTIFIER>823035192</IDENTIFIER><PURPOSE>DEBTID</PURPOSE></CUSIP_ALIAS_record></CUSIP_ALIAS_set><CUSIP_TYPE>CUSIP</CUSIP_TYPE><DATE_CONV>D30360</DATE_CONV><DESC_INSTMT>BP CAPITAL MARKETS PLC</DESC_INSTMT><END_ADJ_FLAG>N</END_ADJ_FLAG><FIRST_PAY_DT>5/1/2012</FIRST_PAY_DT><FIRST_SETTLE_DT>11/1/2011</FIRST_SETTLE_DT><FLAG_144A>N</FLAG_144A><FLAG_CONVERT>N</FLAG_CONVERT><FLAG_EOM>N</FLAG_EOM><FLAG_ERISA>N</FLAG_ERISA><FLAG_PERFORMING>Y</FLAG_PERFORMING><FLAG_REG_RIGHTS>N</FLAG_REG_RIGHTS><ISSUER_ID>N15397</ISSUER_ID><ISSUE_DT>11/1/2011</ISSUE_DT><ISSUE_EXCHANGES_set SIZE=\"2\"><ISSUE_EXCHANGES_record><EXCHANGE>NSD</EXCHANGE></ISSUE_EXCHANGES_record><ISSUE_EXCHANGES_record><EXCHANGE>NYS</EXCHANGE></ISSUE_EXCHANGES_record></ISSUE_EXCHANGES_set><ISSUE_PRICE>100</ISSUE_PRICE><LEH_INDUSTRY>INTG</LEH_INDUSTRY><LIQUIDITY>L</LIQUIDITY><MARKET>US</MARKET><MATURITY>11/1/2016</MATURITY><MIN_LOT_SIZE>1000</MIN_LOT_SIZE><MIN_TRD_SIZE>1000</MIN_TRD_SIZE><MODIFIED_BY>ngasperi</MODIFIED_BY><MTN>N</MTN><NTL_FLAG>N</NTL_FLAG><PMT_ADJ_METH>F</PMT_ADJ_METH><PMT_CAL>NY_Bank|LN</PMT_CAL><PMT_FREQ_TYPE>0</PMT_FREQ_TYPE><PMT_LOCATION>D</PMT_LOCATION><PRICE_AS_PCT>Y</PRICE_AS_PCT><PUT_CALL> </PUT_CALL><RATING_set SIZE=\"4\"><RATING_record><AGY>1</AGY><DATE>9/8/2014</DATE><VALUE>A2</VALUE></RATING_record><RATING_record><AGY>2</AGY><DATE>11/3/2011</DATE><VALUE>A</VALUE></RATING_record><RATING_record><AGY>3</AGY><DATE>10/29/2014</DATE><VALUE>A</VALUE></RATING_record><RATING_record><AGY>50</AGY><DATE>12/17/2014</DATE><VALUE>A</VALUE></RATING_record></RATING_set><REVIEWED_BY>ngasperi</REVIEWED_BY><ROUND_FLAG>R</ROUND_FLAG><ROUND_PRECISION>9</ROUND_PRECISION><SAL_INDUSTRY>OILI</SAL_INDUSTRY><SECTOR_set SIZE=\"3\"><SECTOR_record><CODE>INTG</CODE><LEVEL>1</LEVEL><SECTOR_SOURCE>P</SECTOR_SOURCE><TYPE>BARC_SECT</TYPE></SECTOR_record><SECTOR_record><CODE>0537</CODE><LEVEL>1</LEVEL><SECTOR_SOURCE>P</SECTOR_SOURCE><TYPE>ISS_IBOXX</TYPE></SECTOR_record><SECTOR_record><CODE>ENGI</CODE><LEVEL>1</LEVEL><SECTOR_SOURCE>P</SECTOR_SOURCE><TYPE>ISS_ML</TYPE></SECTOR_record></SECTOR_set><SEC_TYPE>BND_CORP</SEC_TYPE><SETTLE_LOCATION>D</SETTLE_LOCATION><SM_SEC_GROUP>BND</SM_SEC_GROUP><SM_SEC_TYPE>CORP</SM_SEC_TYPE><STRUCTURE>SENIOR</STRUCTURE><TICKER>BPLN</TICKER><UDF_set SIZE=\"1\"><UDF_record><LABEL>LIQ_SC</LABEL><PURPOSE>DB</PURPOSE><VALUE>2</VALUE></UDF_record></UDF_set><UNITS>BONDS</UNITS><WI_FLAG>N</WI_FLAG></FhlmcModel_BND_CORP></ASSET></ASSETS>");

	}
}
*/