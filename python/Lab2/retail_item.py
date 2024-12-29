# author: Lindokuhle Dubazane
# partner1: Rethabile Sitole
# partner2: Nkululeko Banda
def main():
    item_description = get_retail_item_description()
    quantity_purchased = get_number_of_purchased_items()
    item_price_usd = get_price_usd_per_unit()
    tax_rate_usd = get_tax_rate()
    subtotal_price_usd = calculate_subtotal_usd(item_price_usd, quantity_purchased)
    tax_usd = calculate_tax_usd(subtotal_price_usd, tax_rate_usd)
    total_price_usd = calculate_total_usd(subtotal_price_usd, tax_usd)

    print("Sales Receipt:")
    print("Item Description:", item_description)
    print("Number of Purchased items:", quantity_purchased)
    print("Unit price (usd):", item_price_usd)
    print("Tax Rate:", tax_rate_usd)
    print("Subtotal:", subtotal_price_usd, "(usd)")
    print("Tax:", tax_usd, "(usd)")
    print("Total:", total_price_usd, "(usd)")


def get_retail_item_description():
    """
    This function allows the user to enter item description
    :return: the function return item description
    """
    retail_item_description = input("Enter the retail item description:")
    return retail_item_description


def get_number_of_purchased_items():
    """
    This function allows user to enter number of purchased item
    :return: the function returns the number of purchased items
    """
    quantity_sold = int(input("Enter quantity purchased:"))
    return quantity_sold


def get_price_usd_per_unit():
    """
    THis function allows the user to enter the  price (usd) per unit
    :return: the function return price of the item in usd per unit
    """
    item_price_per_unit_usd = float(input("Enter price per unit(usd):"))
    return item_price_per_unit_usd


def get_tax_rate():
    """
    This function allows user to enter the tax rate
    :return: the function return thr tax rate
    """
    tax_rate = float(input("Enter tax:"))
    return tax_rate


def calculate_subtotal_usd(item_price_per_unit_usd, quantity_sold):
    """
    This function calculate the subtotal in usd of the item purchased
    :param item_price_per_unit_usd: price of the item purchased
    :param quantity_sold: Number of units sold
    :return: the function returns the subtotal amount in usd
    """
    subtotal_amount_usd = item_price_per_unit_usd * quantity_sold
    return subtotal_amount_usd


def calculate_tax_usd(subtotal_amount_usd, tax_rate):
    """
    This function calculate the tax amount of the item purchased in usd
    :param subtotal_amount_usd: subtotal price of the purchased item
    :param tax_rate: tax rate of the item in usd
    :return: the function returns the tax price of the item
    """
    tax_amount = subtotal_amount_usd * tax_rate
    return tax_amount


def calculate_total_usd(subtotal_amount_usd, tax_amount):
    """
    This function calculate total amount of the item purchased in usd
    :param subtotal_amount_usd: subtotal price of the purchased item
    :param tax_amount: tax price of the purchased item
    :return: the function returns total amount in usd
    """
    total_amount_usd = subtotal_amount_usd + tax_amount
    return total_amount_usd


if __name__ == "__main__":
    main()
