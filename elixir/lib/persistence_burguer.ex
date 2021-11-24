defmodule PersistenceBurguer do
  require Integer

  def persistence(n, count \\ 0)
  def persistence(n, count) when n < 10, do: count
  def persistence(n, count) do
    Integer.digits(n)
    |> product
    |> persistence(count + 1)
  end

  def product(digits) do
    Enum.reduce(digits, fn(digit, acc) -> digit * acc end)
  end

end
