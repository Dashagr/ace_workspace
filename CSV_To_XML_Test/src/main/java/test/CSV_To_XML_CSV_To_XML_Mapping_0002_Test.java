package test;

import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.ibm.integration.test.v1.NodeSpy;
import com.ibm.integration.test.v1.SpyObjectReference;
import com.ibm.integration.test.v1.TestMessageAssembly;
import com.ibm.integration.test.v1.TestSetup;
import com.ibm.integration.test.v1.exception.TestException;

import static com.ibm.integration.test.v1.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CSV_To_XML_CSV_To_XML_Mapping_0002_Test {

	/*
	 * CSV_To_XML_CSV_To_XML_Mapping_0002_Test
	 * Test generated by IBM App Connect Enterprise Toolkit 12.0.1.0 on Nov 19, 2021 1:35:39 PM
	 */

	@AfterEach
	public void cleanupTest() throws TestException {
		// Ensure any mocks created by a test are cleared after the test runs 
		TestSetup.restoreAllMocks();
	}

	@Test
	public void CSV_To_XML_CSV_To_XML_Mapping_TestCase_001() throws TestException {

		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("CSV_To_XML").messageFlow("CSV_To_XML")
				.node("Mapping");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/CSV_To_XML_Mapping_0001_de7448ed-ee36-43cd-a2ed-64c13826e01e_input_data.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

		/* Compare Output Message 1 at output terminal out */

		try {
			TestMessageAssembly actualMessageAssembly = null;
			TestMessageAssembly expectedMessageAssembly = null;

			// Get the TestMessageAssembly object for the actual propagated message
			actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

			// Assert output message body data
			// Get the TestMessageAssembly object for the expected propagated message
			expectedMessageAssembly = new TestMessageAssembly();

			// Create a Message Assembly from the expected output mxml resource
			String messageAssemblyPath = "/CSV_To_XML_Mapping_0001_e381c5a8-1d86-4f31-8ed3-c3fab0620237_output_data.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);

			// Assert that the actual message tree matches the expected message tree
			assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly));

		} catch (Exception ex) {
			throw new TestException("Failed to compare with expected message", ex);
		}

	}

}
