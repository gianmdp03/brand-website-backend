package com.gianmdp03.brand_website.model;

import com.gianmdp03.brand_website.extra._enum.OrderStatus;
import com.gianmdp03.brand_website.extra.servicedetail.ServiceDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.Map;

@Entity
@Table(name = "service_orders")
@NoArgsConstructor
@Getter
@Setter
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus = OrderStatus.PENDING;

    @JdbcTypeCode(SqlTypes.JSON) //crear clases
    @Column(columnDefinition = "jsonb")
    private Map<String, ServiceDetail> serviceDetail;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    public ServiceOrder(Map<String, ServiceDetail> serviceDetail, Client client, BigDecimal price) {
        this.serviceDetail = serviceDetail;
        this.client = client;
        this.price = price;
    }
}
