defmodule PersistenceBurguerTest do
  use ExUnit.Case
  import PersistenceBurguer

  test "persistence burguer of 39 should return 3" do
    assert persistence(39) == 3
  end

  test "persistence burguer of 25 should return 2" do
    assert persistence(25) == 2
  end

  test "persistence burguer of 999 should return 4" do
    assert persistence(999) == 4
  end
end
