create table customers
(
    id					bigserial not null,
    customer_name		varchar   not null,
    created_at 			timestamp with time zone NOT NULL DEFAULT now(),
    updated_at			timestamp with time zone,
    primary key (id)
);