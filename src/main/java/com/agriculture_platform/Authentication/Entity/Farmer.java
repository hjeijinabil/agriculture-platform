package com.agriculture_platform.Authentication.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Farmer extends User {
    private String farmName;
    private String location;
    private String scaling;
    private String profession;
    private String farmingBackground;

//    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
//    private List<Farm> farms = new ArrayList<>();

    // Indicates whether the farmer owns or leases the land
    private boolean farmOwner;

    // Number of years of farming experience
    private int farmingExperience;

    // Highest level of education attained by the farmer
//    private Studylevel educationLevel;

    // Short-term and long-term objectives in farming
    @ElementCollection
    private List<String> farmingGoals;

    // Budget allocated for farming activities
    private double farmingBudget;

    // Expenses incurred in farming
    private double farmingExpenses;

    // Income generated from farming
    private double farmingIncome;

    // Records of training and workshops attended
    @ElementCollection
    private List<String> trainingAndWorkshops;

    // Information about past mentors or advisors
    @ElementCollection
    private List<String> mentoringHistory;

    // Challenges or obstacles faced by the farmer
    @ElementCollection
    private List<String> challengesFaced;

    // Feedback received from mentors or advisors
    @ElementCollection
    private List<String> feedbackAndRecommendations;

    // Requests for mentorship or assistance
//    @OneToMany(mappedBy = "requester", cascade = CascadeType.ALL)
//    private List<MentoringRequest> mentoringRequests;
}
