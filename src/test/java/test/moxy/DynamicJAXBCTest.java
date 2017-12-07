/**
 * 
 */
package test.moxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.xml.namespace.QName;

import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.jaxb.JAXBUnmarshaller;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContext;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory;
import org.junit.Test;

/**
 * @author gselvaratnam
 *
 */
public class DynamicJAXBCTest {

	@Test
	public void test() throws Exception {
		ClassLoader myClassLoader = this.getClass().getClassLoader();
		// InputStream inputStream =
		// myClassLoader.getSystemResourceAsStream("resources/xsd/customer.xsd");
		File newFile = new File("src/main/resources/xsd/customer.xsd");
		InputStream inputStream = new FileInputStream(newFile);

		DynamicJAXBContext dContext = DynamicJAXBContextFactory.createContextFromXSD(inputStream, null, null, null);

		DynamicEntity newCustomer = dContext.newDynamicEntity("example.Customer");
		newCustomer.set("firstName", "George");
		newCustomer.set("lastName", "Jones");

		DynamicEntity newAddress = dContext.newDynamicEntity("example.Address");
		newAddress.set("street", "227 Main St.");
		newAddress.set("city", "Toronto");
		newAddress.set("province", "Ontario");
		newAddress.set("postalCode", "M5V1E6");

		newCustomer.set("address", newAddress);

		dContext.createMarshaller().marshal(newCustomer, System.out);

		JAXBUnmarshaller unmarshaller = dContext.createUnmarshaller();
		FileInputStream xmlInputStream = new FileInputStream("src/test/resources/example/customer.xml");
		javax.xml.bind.JAXBElement newObj = (javax.xml.bind.JAXBElement) unmarshaller.unmarshal(xmlInputStream);

		DynamicEntity customer = (DynamicEntity) newObj.getValue();

		DynamicType customerTYpe = dContext.getDynamicType("example.Customer");
		System.out.println("");
		System.out.println("getClassName : " + customerTYpe.getClassName());
		System.out.println("getNumberOfProperties : " + customerTYpe.getNumberOfProperties());
		System.out.println("getDescriptor : " + customerTYpe.getDescriptor());
		System.out.println("getParentType : " + customerTYpe.getParentType());

		System.out.println("********************* DynamicJAXBContext *********************");
		// Map<QName, Class> qnameToClassMap =
		// dContext.getQNamesToDeclaredClasses();
		// for(QName theKey : qnameToClassMap.keySet()) {
		// System.out.println("QName : " + theKey.getNamespaceURI());
		// System.out.println("Class : " + qnameToClassMap.get(theKey));
		// }
		System.out.println("getArrayClassesToGeneratedClasses " + dContext.getArrayClassesToGeneratedClasses());
		System.out.println("getBeanValidationHelper " + dContext.getBeanValidationHelper());
		System.out.println("getClassToGeneratedClasses " + dContext.getClassToGeneratedClasses());
		System.out
				.println("getCollectionClassesToGeneratedClasses " + dContext.getCollectionClassesToGeneratedClasses());
		System.out.println("getDynamicClassLoader " + dContext.getDynamicClassLoader());
		System.out.println("getQNamesToDeclaredClasses " + dContext.getQNamesToDeclaredClasses());
		// System.out.println("getArrayClassesToGeneratedClasses " +
		// dContext.getTypeMappingInfoToSchemaType());
		System.out.println("getTypeToSchemaType " + dContext.getTypeToSchemaType());
		System.out.println("getXMLContext " + dContext.getXMLContext());
		System.out.println("********************* DynamicJAXBContext *********************");

		System.out.println("********************* Customer *********************");
		DynamicEntity newEntity = null;
		DynamicType newType = null;
		int propIndex = 0;

		System.out.println("getAlias : " + customerTYpe.getDescriptor().getAlias());
		System.out.println("getAmendmentClassName : " + customerTYpe.getDescriptor().getAmendmentClassName());
		System.out.println("getAmendmentMethodName : " + customerTYpe.getDescriptor().getAmendmentMethodName());
		System.out.println("getAccessorTree : " + customerTYpe.getDescriptor().getAccessorTree());
		System.out.println("getAdditionalAggregateCollectionKeyFields : " + customerTYpe.getDescriptor().getAdditionalAggregateCollectionKeyFields());
		System.out.println("getAdditionalTablePrimaryKeyFields : " + customerTYpe.getDescriptor().getAdditionalTablePrimaryKeyFields());
		System.out.println("getAdditionalWritableMapKeyFields : " + customerTYpe.getDescriptor().getAdditionalWritableMapKeyFields());
		System.out.println("getAllFields : " + customerTYpe.getDescriptor().getAllFields());
		System.out.println("getAllSelectionFields : " + customerTYpe.getDescriptor().getAllSelectionFields());
		System.out.println("getAmendmentClass : " + customerTYpe.getDescriptor().getAmendmentClass());
		System.out.println("getAttributeGroups : " + customerTYpe.getDescriptor().getAttributeGroups());
		System.out.println("getTableName : " + customerTYpe.getDescriptor().getTableName());

		System.out.println("getTableNames : " + customerTYpe.getDescriptor().getTableNames());
		System.out.println("getTablePerClassPolicy : " + customerTYpe.getDescriptor().getTablePerClassPolicy());
		System.out.println("getTables : " + customerTYpe.getDescriptor().getTables());
		System.out.println("getCacheInterceptorClassName : " + customerTYpe.getDescriptor().getCacheInterceptorClassName());
		System.out.println("getCacheSynchronizationType : " + customerTYpe.getDescriptor().getCacheSynchronizationType());
		
		System.out.println("getCopyPolicyClassName : " + customerTYpe.getDescriptor().getCopyPolicyClassName());
		System.out.println("getCacheInterceptorClass : " + customerTYpe.getDescriptor().getCacheInterceptorClass());
		System.out.println("getCacheInvalidationPolicy : " + customerTYpe.getDescriptor().getCacheInvalidationPolicy());
		
		System.out.println("getCacheIsolation : " + customerTYpe.getDescriptor().getCacheIsolation());
//		System.out.println("getAccessorTree : " + customerTYpe.getDescriptor().get);
//		System.out.println("getAccessorTree : " + customerTYpe.getDescriptor().getCacheInvalidationPolicy());
//		System.out.println("getAccessorTree : " + customerTYpe.getDescriptor().getCacheInvalidationPolicy());
//		System.out.println("getAccessorTree : " + customerTYpe.getDescriptor().getCacheInvalidationPolicy());
//		System.out.println("getAccessorTree : " + customerTYpe.getDescriptor().getCacheInvalidationPolicy());
//		System.out.println("getAccessorTree : " + customerTYpe.getDescriptor().getCacheInvalidationPolicy());
		
		
		for (String propertyName : customerTYpe.getPropertiesNames()) {
			System.out.println(customer.get(propertyName));
			System.out.println("getPropertyType : " + customerTYpe.getPropertyType(propertyName));
			System.out.println("getPropertyType : " + customerTYpe.getPropertyType(propIndex));
			propIndex++;

			if (customerTYpe.getPropertyType(propertyName) == null) {
				newEntity = customer.<DynamicEntity>get(propertyName);
			}
		}
		System.out.println("********************* Customer *********************");

		// DynamicType addressType = dContext.getDynamicType("example.Address");
		//
		// System.out.println("********************* Address
		// *********************");
		// DynamicEntity address = customer.<DynamicEntity>get("address");
		// for(String propertyName: addressType.getPropertiesNames()) {
		// System.out.println(address.get(propertyName));
		// }
		// System.out.println("********************* Address
		// *********************");

		System.out.println(newObj);
	}
}
