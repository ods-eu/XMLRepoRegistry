/**
 * 
 */
package grnet.com.repo;

import java.util.Iterator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import se.kb.oai.OAIException;
import se.kb.oai.pmh.OaiPmhServer;

/**
 * @author vogias
 * 
 */

@XmlRootElement
public class Repository {

	String name, url, prefix, oaiVersion, delPolicy, granularity, responsible;
	OaiPmhServer server;

	/**
	 * @return the name
	 */

	private void createServer() {
		server = new OaiPmhServer(getUrl());
	}

	public void setPartialInfo() {

		createServer();

		try {
			setOaiVersion(server.identify().getProtocolVersion());
			setDelPolicy(server.identify().getDeletedRecord());
			setGranularity(server.identify().getGranularity());
		} catch (OAIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setFullInfo() {

		createServer();

		try {
			setName(server.identify().getRepositoryName().replace(" ", ""));
			setOaiVersion(server.identify().getProtocolVersion());
			setDelPolicy(server.identify().getDeletedRecord());
			setGranularity(server.identify().getGranularity());
			Iterator<String> iterator = server.identify().getAdminEmails()
					.iterator();
			String next = iterator.next();
			setResponsible(next);
		} catch (OAIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@XmlElement
	public String getName() {
		return name;
	}

	/**
	 * @return the url
	 */
	@XmlElement
	public String getUrl() {
		return url;
	}

	/**
	 * @return the prefix
	 */
	@XmlElement
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @return the oaiVersion
	 */
	@XmlElement
	public String getOaiVersion() {
		return oaiVersion;
	}

	/**
	 * @return the delPolicy
	 */
	@XmlElement
	public String getDelPolicy() {
		return delPolicy;
	}

	/**
	 * @return the granularity
	 */
	@XmlElement
	public String getGranularity() {
		return granularity;
	}

	/**
	 * @return the responsible
	 */
	@XmlElement
	public String getResponsible() {
		return responsible;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @param prefix
	 *            the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @param oaiVersion
	 *            the oaiVersion to set
	 */
	public void setOaiVersion(String oaiVersion) {
		this.oaiVersion = oaiVersion;
	}

	/**
	 * @param delPolicy
	 *            the delPolicy to set
	 */
	public void setDelPolicy(String delPolicy) {
		this.delPolicy = delPolicy;
	}

	/**
	 * @param granularity
	 *            the granularity to set
	 */
	public void setGranularity(String granularity) {
		this.granularity = granularity;
	}

	/**
	 * @param responsible
	 *            the responsible to set
	 */
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	/**
	 * @param server
	 *            the server to set
	 */
	public void setServer(OaiPmhServer server) {
		this.server = server;
	}

}
