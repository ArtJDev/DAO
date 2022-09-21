select product
from product p
         join order_product_list opl on opl.product_id = p.product_id
         join orders o on o.order_id = opl.order_id
         join customer c on c.customer_id = o.customer_id
where c.first_name ilike :name