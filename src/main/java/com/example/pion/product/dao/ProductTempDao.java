package com.example.pion.product.dao;

import com.example.pion.product.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductTempDao {

    @Insert("""
            <script>
                INSERT INTO product(name, price)
                VALUES(
                    #{name, jdbcType=VARCHAR},
                    #{price}
                )
            </script>       \s
            """)
    public void save(Product product);

    @Select("""
		<script>
			SELECT
				id,
				name,
				price
			FROM product
		</script>
		""")
    public List<Product> findAllProduct();

    @Select("""
            <script>
                SELECT * FROM product WHERE id = #{id}
            </script>
            """
    )
    public Product findProductById(String id);
}
