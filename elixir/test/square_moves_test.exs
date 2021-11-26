defmodule SquareMovesTest do
  use ExUnit.Case
  import SquareMoves

  test "test vert mirror" do
    str = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu"
    assert vert_mirror(str) == "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw"
  end

  test "test hor mirror" do
    str = "lVHt\nJVhv\nCSbg\nyeCt"
    assert hor_mirror(str) == "yeCt\nCSbg\nJVhv\nlVHt"
  end

  test "test operation vert_mirror" do
    str = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu"
    assert oper(&vert_mirror/1, str) == "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw"
  end

  test "test operation hor_mirror" do
    str = "lVHt\nJVhv\nCSbg\nyeCt"
    assert oper(&hor_mirror/1, str) == "yeCt\nCSbg\nJVhv\nlVHt"
  end

end
