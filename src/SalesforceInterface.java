import java.util.ArrayList;

import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.sobject.Contact;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.template.Main;

public class SalesforceInterface {
	private static ArrayList<String> usernames = new ArrayList<String>();
	
	public static void main(String[] args) {
		getGitHubUsernames();
	}
	public static ArrayList<String> getGitHubUsernames() {
		ConnectorConfig config = new ConnectorConfig();
		config.setUsername("leaguebot@jointheleague.org");
		config.setPassword("password");
		config.setTraceMessage(false);
		
		try {
			EnterpriseConnection connection = Connector.newConnection(config);
			QueryResult queryResults = connection.query("SELECT GIT_HUB_acct_name__c FROM Contact WHERE GIT_HUB_acct_name__C != null");
			
			SObject[] s = queryResults.getRecords();
			
			for (int i = 0; i < s.length; i++) {
				Contact c = (Contact) s[i];
				System.out.println(c.getGIT_HUB_acct_name__c());
				usernames.add(c.getGIT_HUB_acct_name__c());
			}
		} catch (ConnectionException e) {
			System.out.println("Failed to connect");
			e.printStackTrace();
		}
		
		return usernames;
	}
	
	public boolean contains(String name) {
		for (String s : usernames) {
			if (s.contains(name)) {
				return true;
			}
		}
		return false;
	}
}
