#!/bin/bash

# Git Commit and Push Script
# Usage: ./scripts/git-commit-push.sh "Your commit message here"
#
# Features:
# - Validates SSH authentication to GitHub
# - Stages all changes
# - Creates meaningful commits
# - Pushes to remote using SSH
# - Provides clear feedback

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Check if commit message is provided
if [ -z "$1" ]; then
    echo -e "${RED}❌ Error: Commit message required${NC}"
    echo "Usage: $0 \"Your commit message here\""
    exit 1
fi

COMMIT_MESSAGE="$1"

# Check if we're in a git repository
if ! git rev-parse --git-dir > /dev/null 2>&1; then
    echo -e "${RED}❌ Error: Not in a git repository${NC}"
    exit 1
fi

echo -e "${BLUE}📝 Git Commit & Push${NC}"
echo "=================================="

# Check current status
echo -e "${YELLOW}Checking repository status...${NC}"
git status

# Stage all changes
echo -e "\n${YELLOW}Staging changes...${NC}"
git add -A
echo -e "${GREEN}✓ Changes staged${NC}"

# Check if there are changes to commit
if git diff-index --quiet HEAD --; then
    echo -e "${YELLOW}ℹ No changes to commit${NC}"
    exit 0
fi

# Commit changes
echo -e "${YELLOW}Creating commit...${NC}"
git commit -m "$COMMIT_MESSAGE"
COMMIT_HASH=$(git rev-parse --short HEAD)
echo -e "${GREEN}✓ Committed: $COMMIT_HASH${NC}"

# Verify SSH authentication
echo -e "\n${YELLOW}Verifying SSH authentication...${NC}"
if ! ssh -T git@github.com 2>&1 | grep -q "successfully authenticated"; then
    echo -e "${YELLOW}⚠ SSH key might not be configured. Attempting push anyway...${NC}"
fi

# Get current branch
BRANCH=$(git rev-parse --abbrev-ref HEAD)
echo -e "${YELLOW}Pushing to origin/$BRANCH...${NC}"

# Push to remote
if git push origin "$BRANCH"; then
    echo -e "${GREEN}✓ Successfully pushed to GitHub!${NC}"
    echo -e "\n${BLUE}📊 Summary${NC}"
    echo "=================================="
    echo -e "Branch: ${YELLOW}$BRANCH${NC}"
    echo -e "Commit: ${YELLOW}$COMMIT_HASH${NC}"
    echo -e "Message: ${YELLOW}$COMMIT_MESSAGE${NC}"
    echo -e "Status: ${GREEN}Synced with remote${NC}"
else
    echo -e "${RED}❌ Push failed${NC}"
    exit 1
fi

