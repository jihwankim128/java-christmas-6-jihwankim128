package christmas.domain.orderdetails;

public enum EventBadge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    ETC("없음", 0);

    private final String badgeName;
    private final int minimumBenefit;

    EventBadge(String badgeName, int minimumBenefit) {
        this.badgeName = badgeName;
        this.minimumBenefit = minimumBenefit;
    }

    public static EventBadge getBadge(int finalDiscountPrice) {
        if (finalDiscountPrice >= SANTA.minimumBenefit) {
            return SANTA;
        }
        if (finalDiscountPrice >= TREE.minimumBenefit) {
            return TREE;
        }
        if (finalDiscountPrice >= STAR.minimumBenefit) {
            return STAR;
        }
        return ETC;
    }

    @Override
    public String toString() {
        return badgeName;
    }
}
