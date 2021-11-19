defmodule TimeBasicsTests do
  use ExUnit.Case

  test "assert basic cases" do
    assert TimeBasics.midnight_past(0, 1, 1) == 61000
    assert TimeBasics.midnight_past(1, 1, 1) == 3661000
    assert TimeBasics.midnight_past(0, 0, 0) == 0
    assert TimeBasics.midnight_past(1, 0, 1) == 3601000
    assert TimeBasics.midnight_past(1, 0, 0) == 3600000
  end

end
