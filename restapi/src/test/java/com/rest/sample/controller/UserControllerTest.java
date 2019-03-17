package com.rest.sample.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

public class UserControllerTest extends JerseyTest {

	@Override
	public Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
		return new ResourceConfig(UserController.class);
	}
	
//	@Override
//	protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
//	    return new TestContainerFactory() {
//	        @Override
//	        public TestContainer create(final URI baseUri, final ApplicationHandler application) throws IllegalArgumentException {
//	            return new TestContainer() {
//	                private HttpServer server;
//
//	                @Override
//	                public ClientConfig getClientConfig() {
//	                    return null;
//	                }
//
//	                @Override
//	                public URI getBaseUri() {
//	                    return baseUri;
//	                }
//
//	                @Override
//	                public void start() {
//	                    try {
//	                        this.server = GrizzlyWebContainerFactory.create(
//	                                baseUri, Collections.singletonMap("jersey.config.server.provider.packages", "com.rest.sample.controller")
//	                        );
//	                    } catch (ProcessingException e) {
//	                        throw new TestContainerException(e);
//	                    } catch (IOException e) {
//	                        throw new TestContainerException(e);
//	                    }
//	                }
//
//	                @SuppressWarnings("deprecation")
//					@Override
//	                public void stop() {
//	                    this.server.stop();
//	                }
//	            };
//
//	        }
//	    };
//	}

	@Test
	public void getAll() {
		Response response = target("/user/getAllUser").request().get();
		assertEquals("should return status 200", 200, response.getStatus());
		assertNotNull("Should return user list", response.getEntity().toString());
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	@Test
	public void userGetById() {
		Response output = target("/user/getUserById").queryParam("userId", "1").request().get();
		assertEquals("Should return status 200", 200, output.getStatus());
		assertNotNull("Should return user object as json", output.getEntity());
		System.out.println(output.getStatus());
		System.out.println(output.readEntity(String.class));
	}
	
}
