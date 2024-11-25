package ie.atu.week8.projectexercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    /*@Test
    void testValidateProductFailure()
    {
        Product product = new Product(1L, "Laptop", "Expensive", -1500);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> productService.saveProduct(product));
        assertEquals("Price cannot be negative", iae.getMessage());
    }*/

    /*@Test
    void testValidateProductEmptyName() {
        Product product = new Product(1L, "", "A high-end laptop", 1500);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> productService.saveProduct(product));
        assertEquals("Product name cannot be empty", iae.getMessage());
    }*/

    @Test
    void testApplyDiscountForExpensiveProduct() {
        Product product = new Product(1L, "High-end Laptop", "A premium laptop", 2000);
        Product savedProduct = productService.saveProduct(product);
        assertEquals(1800, savedProduct.getPrice(), 0.01);
    }







}
