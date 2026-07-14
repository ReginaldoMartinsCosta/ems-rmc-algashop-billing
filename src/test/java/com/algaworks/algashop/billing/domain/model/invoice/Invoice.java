package com.algaworks.algashop.billing.domain.model.invoice;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter(AccessLevel.PRIVATE) // Reginaldo: setters PRIVADOS (private)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED) // nivel de acesso "protected"
public class Invoice {

    @EqualsAndHashCode.Include
    private UUID id;
    private String orderId;
    private UUID customerId;

    private OffsetDateTime issuedAt;
    private OffsetDateTime paidAt;
    private OffsetDateTime canceledAt;
    private OffsetDateTime expiresAt;

    private BigDecimal totalAmount;

    private InvoiceStatus status;

    private PaymentSettings paymentSettings;

    private Set<LineItem> items = new HashSet<>();

    private Payer payer;

    private String cancelReason;

    public Set<LineItem> getItems() {
        // Reginaldo: criado manualmente para que a lista de itens seja retornada como unmodifiable
        // e garantindo assim que apenas o Aggregate Root possa modificar os itens
        return Collections.unmodifiableSet(this.items);
    }

    // Reginaldo: não foi acrescentado métodos setter, porque esses outros são mais expressivos (semânticos)
    // e representam o comportamento da operação de negócio

    public void markAsPaid() {

    }

    public void cancel() {

    }

    public void assignPaymentGatewayCode(String code) {

    }

    public void changePaymentSettings(PaymentMethod method, UUID creditCard) {

    }
}
