public class Piece {
    String pType;
    String pColor;
    String moveType;
    boolean pieceHasMoved;

    public Piece(){//blank constructor
        this.pColor = "";
        this.pType = "";
        this.moveType = "";
        this.pieceHasMoved = false;
    }
    public Piece(String tType, String tColor){
        this.pType = tType;
        this.pColor = tColor;
        this.pieceHasMoved = false;
        //----
        // work out how the pieces move
        switch (tType){
            case "King":
                this.moveType = "K";
                break;
            case "Pawn":
                this.moveType = "P";
                break;
            case "Queen":
                this.moveType = "Q";
                break;
            case "Rook":
                this.moveType = "S";
                break;
            case "Bishop":
                this.moveType = "D";
                break;
            case "Knight":
                this.moveType = "L";
                break;
        }
    }
    //this is for when I want to just letter the board places
    public Piece(String arg){
        this.pColor = "";
        this.pType = arg;
        this.moveType = "";
        this.pieceHasMoved = false;
    }

    public boolean validMove(int row, int column){
        return false;

    }


    public String toString() {
        if (pType.isEmpty()) return "[  ]";
        if (pColor.isEmpty()) return  ("[" + pType + "]");
        if(pType=="Knight") return ("[" + "N" + "" + pColor.substring(0, 1) + "]");
        return ("[" + pType.substring(0, 1) + "" + pColor.substring(0, 1) + "]");
    }

}
