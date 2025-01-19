package localdb;


val tasks=listOf(
    mapOf(
        "id" to "task-1",
        "name" to "Clean the house",
        "description" to "Complete the general cleaning tasks around the house.",
        "chores" to listOf(
            mapOf(
                "description" to "Vacuum the carpets and floor to remove dust and debris.",
                "done" to false
            ),
            mapOf(
                "description" to "Wash all dirty dishes from the kitchen sink and dry them.",
                "done" to true
            ),
            mapOf(
                "description" to "Collect all trash from the rooms and take it outside to the bins.",
                "done" to false
            )
        )
    ),
    mapOf(
        "id" to "task-2",
        "name" to "Do the laundry",
        "description" to "Wash, dry, and fold the laundry.",
        "chores" to listOf(
            mapOf(
                "description" to "Fold all the clean laundry into neat piles for storage.",
                "done" to true
            ),
            mapOf(
                "description" to "Iron any wrinkled shirts to make them neat and ready to wear.",
                "done" to false
            ),
            mapOf(
                "description" to "Hang the clothes on the clothesline or in the dryer to air-dry.",
                "done" to true
            )
        )
    ),
    mapOf(
        "id" to "task-3",
        "name" to "Go grocery shopping",
        "description" to "Pick up all necessary groceries for the week.",
        "chores" to listOf(
            mapOf(
                "description" to "Pick fresh vegetables like carrots, tomatoes, and lettuce for the week.",
                "done" to false
            ),
            mapOf(
                "description" to "Grab fruits like apples, bananas, and oranges from the produce section.",
                "done" to true
            ),
            mapOf(
                "description" to "Get snacks like chips, nuts, and cookies for the pantry.",
                "done" to false
            ),
        ),
    ),
    mapOf(
        "id" to "task-4",
        "name" to "Prepare dinner",
        "description" to "Cook a nutritious meal for the family.",
        "chores" to listOf(
            mapOf(
                "description" to "Chop onions, garlic, carrots, and other vegetables for the dish.",
                "done" to true
            ),
            mapOf(
                "description" to "Boil pasta, add sauce, and mix well to prepare a pasta dish.",
                "done" to false
            ),
            mapOf(
                "description" to "Lay out plates, silverware, and glasses for the family to eat.",
                "done" to false
            ),
        ),
    ),
    mapOf(
        "id" to "task-5",
        "name" to "Take out the trash",
        "description" to "Empty all trash bins and take the garbage out to the main bins.",
        "chores" to listOf(
            mapOf(
                "description" to "Empty the kitchen trash can and replace it with a new liner.",
                "done" to false
            ),
            mapOf(
                "description" to "Carry the trash bags outside and throw them into the curbside bins.",
                "done" to true
            ),
        ),
    ),
    mapOf(
        "id" to "task-6",
        "name" to "Organize the office",
        "description" to "Tidy up the workspace to improve efficiency and clarity.",
        "chores" to listOf(
            mapOf(
                "description" to "Sort through any loose papers and file them in the appropriate folders.",
                "done" to false
            ),
            mapOf(
                "description" to "Wipe down the desk and computer area to remove dust and grime.",
                "done" to true
            ),
            mapOf(
                "description" to "Move books and materials around to create a more organized shelf.",
                "done" to true
            )
        )
    ),
    mapOf(
        "id" to "task-7",
        "name" to "Pay bills",
        "description" to "Ensure that all bills are paid on time.",
        "chores" to listOf(
            mapOf(
                "description" to "Log into the utility company’s website and pay the electricity bill.",
                "done" to true
            ),
            mapOf(
                "description" to "Log into the service provider’s account and settle the internet bill.",
                "done" to false
            )
        )
    ),
    mapOf(
        "id" to "task-8",
        "name" to "Exercise",
        "description" to "Complete a workout to stay healthy.",
        "chores" to listOf(
            mapOf(
                "description" to "Go for a 5km run around the neighborhood or park.",
                "done" to false
            ),
            mapOf(
                "description" to "Perform 30 minutes of yoga to improve flexibility and mental clarity.",
                "done" to true
            )
        )
    ),
    mapOf(
        "id" to "task-9",
        "name" to "Walk the dog",
        "description" to "Give the dog some exercise by taking it on a walk.",
        "chores" to listOf(
            mapOf(
                "description" to "Attach the leash to the dog’s collar before heading out.",
                "done" to true
            ),
            mapOf(
                "description" to "Walk the dog for 30 minutes around the neighborhood.",
                "done" to true
            )
        )
    ),
    mapOf(
        "id" to "task-10",
        "name" to "Attend team meeting",
        "description" to "Participate in the weekly team meeting.",
        "chores" to listOf(
            mapOf(
                "description" to "Prepare the meeting agenda and share it with the team.",
                "done" to true
            ),
            mapOf(
                "description" to "Join the meeting via video call at the scheduled time.",
                "done" to false
            )
        )
    ),
    mapOf(
        "id" to "task-11",
        "name" to "Clean the windows",
        "description" to "Wash all the windows in the house to let in more light.",
        "chores" to listOf(
            mapOf(
                "description" to "Wipe down the living room windows with a glass cleaner.",
                "done" to false
            ),
            mapOf(
                "description" to "Wash the bedroom windows to remove dust and streaks.",
                "done" to true
            )
        )
    ),
    mapOf(
        "id" to "task-12",
        "name" to "Change bed sheets",
        "description" to "Replace the old bed sheets with fresh, clean ones.",
        "chores" to listOf(
            mapOf(
                "description" to "Take off the old bed sheets and pillowcases.",
                "done" to false
            ),
            mapOf(
                "description" to "Put on the new sheets and make the bed.",
                "done" to true
            )
        )
    ),
    mapOf(
        "id" to "task-13",
        "name" to "Mow the lawn",
        "description" to "Cut the grass and keep the yard tidy.",
        "chores" to listOf(
            mapOf(
                "description" to "Use the lawn mower to cut the grass in the front yard.",
                "done" to false
            ),
            mapOf(
                "description" to "Mow the backyard to keep it neat and tidy.",
                "done" to true
            )
        )
    ),
).mapIndexed { i,task -> task+mutableMapOf(
    "done" to (i%2==0),
)};